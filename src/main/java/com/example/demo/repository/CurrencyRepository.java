package com.example.demo.repository;

import com.example.demo.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
    boolean existsByName(String name);
}
