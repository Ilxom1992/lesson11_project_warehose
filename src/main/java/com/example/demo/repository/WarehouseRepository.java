package com.example.demo.repository;

import com.example.demo.entity.WhereHouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<WhereHouse,Integer> {
    boolean existsByName(String name);
}
