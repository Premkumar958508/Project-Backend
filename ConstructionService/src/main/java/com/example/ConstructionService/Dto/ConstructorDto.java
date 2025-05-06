package com.example.ConstructionService.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ConstructorDto {
    private Long constructionId;
    private String name;
    private int experience;
    private String specialization;
    private boolean available;
}
