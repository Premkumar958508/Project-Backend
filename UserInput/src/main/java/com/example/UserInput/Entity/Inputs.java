package com.example.UserInput.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "inputs")
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class Inputs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
