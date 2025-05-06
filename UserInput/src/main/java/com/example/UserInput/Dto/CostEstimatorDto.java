package com.example.UserInput.Dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class CostEstimatorDto {

    private Long constructionId;
    private int projectId;
    private int constructorId;
    private Double totalEstimate;
    private Date generatedAt;

}
