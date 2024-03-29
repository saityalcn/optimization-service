package com.example.optimization.service;

import com.example.optimization.client.AlgorithmClient;
import com.example.optimization.dto.AlgorithmRequestDTO;
import com.example.optimization.dto.OrderDTO;
import com.example.optimization.dto.ProductionPlanDTO;
import com.example.optimization.model.*;
import com.example.optimization.repository.ProductionPlanRepository;
import org.aspectj.weaver.ast.Or;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductionPlanService {

    @Autowired
    ProductionPlanRepository repository;

    @Autowired
    RawMaterialInformationService rawMaterialInformationService;

    @Autowired
    OrderPlannedProductionService orderPlannedProductionService;

    @Autowired
    MethodService methodService;

    @Autowired
    private final RestTemplate restTemplate;

    private ModelMapper modelMapper = new ModelMapper();
    private final String apiUrl = "http://localhost:5000/";



    @Autowired
    public ProductionPlanService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<ProductionPlanDTO> getProductionPlans(){
        return repository.findAll().stream().map(e -> modelMapper.map(e, ProductionPlanDTO.class)).collect(Collectors.toList());
    }

    public ProductionPlan addProductionPlan(ProductionPlan plan){
        return repository.save(plan);
    }

    public void saveOptimizedProduction(Long productionPlanId){
        ProductionPlan productionPlan = repository.findById(productionPlanId).get();
        List<OrderPlannedProduction> plannedProductionList = new ArrayList<>();
        List<Method> methods = methodService.getAllMethods();
        for(Method method: methods){
            plannedProductionList.addAll(createPlannedList(productionPlan, method));
        }

        productionPlan.setPlannedProductionList(orderPlannedProductionService.addAll(plannedProductionList));
        repository.save(productionPlan);
    }

    private List<OrderPlannedProduction> createPlannedList(ProductionPlan productionPlan, Method method){
        List<HashMap<String, Double>> optimizationResult = this.postOptimizationModel(productionPlan, method);
        List<OrderPlannedProduction> plannedProductionList = new ArrayList<>();
        if(optimizationResult.size() > 0) {
            OrderPlannedProduction orderPlannedProduction = new OrderPlannedProduction();
            orderPlannedProduction.setMethod(method);
            orderPlannedProduction.setStartDate(productionPlan.getStartDate());
            orderPlannedProduction.setEndDate(addDaysToDate(orderPlannedProduction.getStartDate(), optimizationResult.get(0).get("age")));
            optimizationResult.get(0).remove("age");
            plannedProductionList.add(orderPlannedProduction);
            for (int i = 1; i < optimizationResult.size(); i++) {
                orderPlannedProduction = new OrderPlannedProduction();
                orderPlannedProduction.setMethod(method);
                orderPlannedProduction.setStartDate(plannedProductionList.get(i - 1).getEndDate());
                orderPlannedProduction.setEndDate(addDaysToDate(orderPlannedProduction.getStartDate(), optimizationResult.get(i).get("age")));
                optimizationResult.get(i).remove("age");
                plannedProductionList.add(orderPlannedProduction);
            }

            for (int i = 0; i < optimizationResult.size(); i++) {
                plannedProductionList.get(i).setOrderPlannedProductionRawMaterials(new ArrayList<>());
                for (String key : optimizationResult.get(i).keySet()) {
                    OrderPlannedProductionRawMaterial rawMaterial = new OrderPlannedProductionRawMaterial();
                    rawMaterial.setInformation(rawMaterialInformationService.getByMaterialName(key));
                    rawMaterial.setQuantity(optimizationResult.get(i).get(key));
                    plannedProductionList.get(i).getOrderPlannedProductionRawMaterials().add(rawMaterial);
                }
            }
        }

        return plannedProductionList;
    }

    private List<HashMap<String, Double>> postOptimizationModel(ProductionPlan productionPlan, Method method){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<Object> requestBody = new HttpEntity<>(createAlgorithmRequestDTO(productionPlan, method), headers);

        ResponseEntity<List> response = restTemplate.postForEntity(apiUrl + "/optimization",requestBody, List.class);
        return (List<HashMap<String, Double>>) response.getBody();
    }

    private AlgorithmRequestDTO createAlgorithmRequestDTO(ProductionPlan productionPlan, Method method){
        AlgorithmRequestDTO dto = new AlgorithmRequestDTO();
        dto.setOrders(new ArrayList<>());
        for(Order order: productionPlan.getOrders()){
            HashMap<String, Long> map = new HashMap<>();
            map.put("min", order.getProduct().getStrengthMin());
            map.put("max", order.getProduct().getStrengthMax());
            map.put("quantity", order.getOrderQuantity());
            dto.getOrders().add(map);
        }

        dto.setRawMaterials(new HashMap<>());
        for(RawMaterial rawMaterial: productionPlan.getRawMaterials()){
            dto.getRawMaterials().put(rawMaterial.getInformation().getMaterialName(), rawMaterial.getQuantity());
        }

        dto.getRawMaterials().put("age", getNumberOfDaysBetweenDates(productionPlan.getStartDate(), productionPlan.getEndDate()));
        dto.setAlgorithmKey(method.getOptimizationAlgorithmKey());
        dto.setOperationsResearchMethodKey(method.getOperationsResearchMethodKey());
        dto.setRegressionModelKey(method.getRegressionModelKey());

        return dto;
    }


    private Long getNumberOfDaysBetweenDates(Date firstDate, Date secondDate){
        long millisPerDay = 24 * 60 * 60 * 1000;
        return Math.abs(secondDate.getTime() - firstDate.getTime()) / millisPerDay;
    }

    private Date addDaysToDate(Date startDate, double daysToAdd){
        long daysToAddAsLong = (long) daysToAdd;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        calendar.add(Calendar.DAY_OF_MONTH, (int) daysToAddAsLong);

        double remainingMillis = (daysToAdd - daysToAddAsLong) * 24 * 60 * 60 * 1000;
        calendar.add(Calendar.MILLISECOND, (int) remainingMillis);

        return calendar.getTime();
    }

}
