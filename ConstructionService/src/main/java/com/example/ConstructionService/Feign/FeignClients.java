package com.example.ConstructionService.Feign;

import com.example.ConstructionService.Dto.InputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "UserInput",url = "http://localhost:8081/api/inputs")
public interface FeignClients {

    @PatchMapping("/api/inputs/{inputId}/setConstructionId/{constructionId}")
    void assignConstructorToInput(@PathVariable Long inputId,@PathVariable Long constructionId);

    @GetMapping("/api/inputs/constructor/{constructorId}")
    List<InputDto> getInputsByConstructorId(@PathVariable Long constructorId);
}
