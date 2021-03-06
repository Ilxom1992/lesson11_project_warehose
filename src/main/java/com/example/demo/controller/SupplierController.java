package com.example.demo.controller;

import com.example.demo.entity.Supplier;
import com.example.demo.payload.Result;
import com.example.demo.servise.SupplierService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    final SupplierService supplierService;


    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    //CREATE
    @PostMapping
    public Result addSupplie(@RequestBody Supplier supplier){
        return supplierService.addSupplier(supplier);
    }
    //READ
    //UPDATE
    //DELETE
    //READ BY ID
}
