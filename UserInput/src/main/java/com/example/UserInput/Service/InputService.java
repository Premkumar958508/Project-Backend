package com.example.UserInput.Service;

import com.example.UserInput.Client.FeignClients;
import com.example.UserInput.Dto.ConstructorDto;
import com.example.UserInput.Entity.Inputs;
import com.example.UserInput.Repository.InputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InputService {

    @Autowired
    private InputRepository inputRepository;
    @Autowired
    private FeignClients feignClient;

    public Inputs createInputs(Inputs inputs){
        return inputRepository.save(inputs);
    }

    public List<Inputs> getAllInputs(){
        return inputRepository.findAll();
    }

    public Optional<Inputs> getInputsById(Long id){
        return inputRepository.findById(id);
    }

    public Inputs assignConstructor(Long inputId, String specialization){
        Inputs input = inputRepository.findById(inputId)
                .orElseThrow(()-> new RuntimeException("Input not found with id : "+inputId));

        ConstructorDto availableConstructor = feignClient
                .getAvailableConstructor(specialization,true);
        if (availableConstructor == null){
            throw new RuntimeException("Constructor not available with specialization"+specialization);
        }
        input.setConstructionId(availableConstructor.getConstructionId());
        inputRepository.save(input);

        feignClient.assignConstructor(availableConstructor.getConstructionId());
        return input;
    }

    public Inputs updateConstructionId(Long inputId, Long constructionId) {
        Inputs input = inputRepository.findById(inputId)
                .orElseThrow(() -> new RuntimeException("Input not found"));
        input.setConstructionId(constructionId);
        return  inputRepository.save(input);
    }

    public List<Inputs> getInputsByConstructorId(Long constructorId) {
        return inputRepository.findByConstructionId(constructorId);
    }



}
