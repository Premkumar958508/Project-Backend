package com.example.ConstructionService.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ConstructorWithInputDto {

    private ConstructorDto constructorDto;
    private List<InputDto> inputDto;
}
