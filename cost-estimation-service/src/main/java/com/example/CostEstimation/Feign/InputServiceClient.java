package com.example.CostEstimation.Feign;

import com.example.CostEstimation.Dto.InputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-input-service", url = "http://localhost:8081") // Update with actual service name if using Eureka
public interface InputServiceClient {

    @GetMapping("/api/inputs/getid/{inputId}")
    InputDTO getInputDetails(@PathVariable("inputId") Long inputId);
}

