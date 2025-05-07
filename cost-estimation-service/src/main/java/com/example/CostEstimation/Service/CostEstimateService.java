package com.example.CostEstimation.Service;

import com.example.CostEstimation.Dto.InputDTO;
import com.example.CostEstimation.Feign.InputServiceClient;
import com.example.CostEstimation.Model.CostEstimate;
import com.example.CostEstimation.Repository.CostEstimateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostEstimateService {

    @Autowired
    private CostEstimateRepository costEstimateRepository;

    @Autowired
    private InputServiceClient inputServiceClient;

    public CostEstimate calculateCost(Long inputId) {
        InputDTO inputDTO = inputServiceClient.getInputDetails(inputId);

        if (inputDTO == null) {
            throw new RuntimeException("Failed to fetch input details from Inputs Service");
        }

        String constructionType = inputDTO.getConstructionType();
        double costPerSqFt = switch (constructionType) {
            case "InteriorDesign" -> 1200;
            case "NewConstruction" -> 1500;
            case "Renovation" -> 1000;
            default -> throw new IllegalArgumentException("Invalid construction type: " + constructionType);
        };

        double totalCost = inputDTO.getBuiltupArea() * inputDTO.getTotalFloor() * costPerSqFt;

        CostEstimate estimate = new CostEstimate();
        estimate.setInputId(inputDTO.getId());
        estimate.setBuiltupArea(inputDTO.getBuiltupArea());
        estimate.setTotalCost(totalCost);
        return costEstimateRepository.save(estimate);
    }

    public List<CostEstimate> getAllEstimates() {
        return costEstimateRepository.findAll();
    }

    public Optional<CostEstimate> getCostEstimate(Long inputId) {
        return costEstimateRepository.findByInputId(inputId);
    }
}
