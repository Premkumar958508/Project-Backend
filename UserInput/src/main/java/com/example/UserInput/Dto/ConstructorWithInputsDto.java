package com.example.UserInput.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ConstructorWithInputsDto {

    private ConstructorDto constructorDto;
    private List<Object> inputDto;
}
