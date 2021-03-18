package com.example.demo.controller;

import com.example.demo.entity.WhereHouse;
import com.example.demo.payload.Result;
import com.example.demo.servise.WarehouseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {

    final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @PostMapping(value = "/upload")
    public Result addWarehouse(@RequestBody WhereHouse warehouse) {

        Result result = warehouseService.addWarehouse(warehouse);
        return result;
    }

    @GetMapping(value = "/get")
    public List<WhereHouse> getWarehouses() {

        List<WhereHouse> warehouses = warehouseService.getWarehouses();
        return warehouses;
    }

    @PutMapping(value = "/edit/{warehouseId}")
    public Result editWarehouse(@PathVariable Integer warehouseId, @RequestBody WhereHouse warehouse) {

        Result result = warehouseService.editWarehouse(warehouseId, warehouse);
        return result;
    }
    @DeleteMapping(value = "/delete/{warehouseId}")
    public Result deleteWarehouse(@PathVariable Integer warehouseId){

        Result result = warehouseService.deleteWarehouse(warehouseId);
        return result;
    }
}
