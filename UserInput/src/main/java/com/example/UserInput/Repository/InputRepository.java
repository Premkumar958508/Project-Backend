package com.example.UserInput.Repository;

import com.example.UserInput.Entity.Inputs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InputRepository extends JpaRepository<Inputs,Long> {

    List<Inputs> findByConstructionId(Long constructionId);
}
