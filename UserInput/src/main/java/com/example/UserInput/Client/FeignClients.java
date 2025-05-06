package com.example.UserInput.Client;

import com.example.UserInput.Dto.ConstructorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ConstructionService",url = "http://localhost:8082/api/constructors")
public interface FeignClients {

    @GetMapping
    ConstructorDto getAvailableConstructor(@RequestParam("specialization") String specialization,@RequestParam("available") Boolean available);

    @PostMapping("/{id}/assign")
    void assignConstructor(@PathVariable("id") Long constructorId);

}
