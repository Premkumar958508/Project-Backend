package com.example.ConstructionService.Service;

import com.example.ConstructionService.Dto.ConstructorDto;
import com.example.ConstructionService.Dto.ConstructorWithInputDto;
import com.example.ConstructionService.Dto.InputDto;
import com.example.ConstructionService.Entity.Constructor;
import com.example.ConstructionService.Feign.FeignClients;
import com.example.ConstructionService.Repository.ConstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConstructorService {

    @Autowired
    private ConstructorRepo constructorRepo;

    @Autowired
    private FeignClients feignClients;

    // Fetch all constructors
    public List<Constructor> getAllConstructors() {
        return constructorRepo.findAll();
    }

    // Fetch a constructor by ID
    public Optional<Constructor> getConstructorById(Long id) {
        return constructorRepo.findById(id);
    }

    // Add a new constructor
    public Constructor addConstructor(Constructor constructor) {
        return constructorRepo.save(constructor);
    }

    // Update constructor availability
    public Constructor updateAvailability(Long id, boolean availability) {
        Constructor constructor = constructorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Constructor not found"));
        constructor.setAvailable(availability);
        return constructorRepo.save(constructor);
    }

    public Constructor assignConstructorToProject(Long constructorId, Long inputId) {
        Constructor constructor = constructorRepo.findById(constructorId)
                .orElseThrow(() -> new RuntimeException("Constructor not found"));

        if (!constructor.isAvailable()) {
            throw new RuntimeException("Constructor is not available");
        }

        constructor.setAvailable(false);
        Constructor updatedConstructor = constructorRepo.save(constructor);

        feignClients.assignConstructorToInput(inputId, constructorId); // Feign call

        return updatedConstructor;
    }

    public List<Constructor> findAvailableConstructors(String specialization) {
        return constructorRepo.findBySpecializationAndAvailable(specialization, true);
    }


    public ConstructorWithInputDto getConstructorWithInputs(Long constructorId) {
        Constructor constructor = constructorRepo.findById(constructorId)
                .orElseThrow(() -> new RuntimeException("Constructor not found"));

        ConstructorDto constructorDto = new ConstructorDto();
        constructorDto.setConstructionId(constructor.getConstructionId());
        constructorDto.setName(constructor.getName());
        constructorDto.setSpecialization(constructor.getSpecialization());
        constructorDto.setAvailable(constructor.isAvailable());

        List<InputDto> inputs = feignClients.getInputsByConstructorId(constructorId); // Feign call

        ConstructorWithInputDto dto = new ConstructorWithInputDto();
        dto.setConstructorDto(constructorDto);
        dto.setInputDto(inputs);

        return dto;
    }




}
