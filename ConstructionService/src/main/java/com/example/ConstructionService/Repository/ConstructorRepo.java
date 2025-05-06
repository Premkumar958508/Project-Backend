package com.example.ConstructionService.Repository;

import com.example.ConstructionService.Entity.Constructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConstructorRepo extends JpaRepository<Constructor,Long> {

    List<Constructor> findBySpecializationAndAvailable(String specialization,Boolean b);
}
