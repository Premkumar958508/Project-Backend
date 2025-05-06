package com.example.ConstructionService.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter @AllArgsConstructor @NoArgsConstructor
public class InputDto {

    private Long id;
    private Double buildupArea;
    private Long phoneNumber;
    private String userEmail;
    private String userName;
    private String city;
    private String state;
    private String constructionType;
    private int totalFloor;
    private String propName;
    private Boolean landClearance;
    private String materialQuality;
    private Long constructionId;
}
