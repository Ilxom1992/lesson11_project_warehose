package com.example.demo.repository;

import com.example.demo.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {

    boolean existsByName(String name);
}
