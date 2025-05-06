package com.example.UserInput.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter @NoArgsConstructor @AllArgsConstructor
public class InputDto {

    private Long id;
    private Double buildupArea;
    private Long mobileNumber;
    private String userName;
    private String userEmail;
    private String city;
    private String state;
    private String constructionType;
    private int totalFloor;
    private String propertyName;
    private Boolean landClearance;
    private String materialQuality;
    private Long constructionId;
}
