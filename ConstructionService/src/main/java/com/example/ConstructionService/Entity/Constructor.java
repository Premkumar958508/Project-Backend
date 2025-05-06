package com.example.ConstructionService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "construction")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Constructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long constructionId;
    private String name;
    private int experience;
    private String specialization;
    private boolean available;
}
