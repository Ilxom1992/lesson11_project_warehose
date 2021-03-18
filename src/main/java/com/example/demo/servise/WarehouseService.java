package com.example.demo.servise;

import com.example.demo.entity.WhereHouse;
import com.example.demo.payload.Result;
import com.example.demo.repository.WarehouseRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
@Service
public class WarehouseService {

    final WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }


    public Result addWarehouse(@RequestBody WhereHouse warehouse) {

        boolean existsByName = warehouseRepository.existsByName(warehouse.getName());
        if (existsByName)
            return new Result("The Warehouse name already exist!", false);

        WhereHouse newWarehouse = new WhereHouse();

        newWarehouse.setName(warehouse.getName());
        warehouseRepository.save(newWarehouse);
        return new Result("New Warehouse successfully saved.", true);
    }

    public List<WhereHouse>getWarehouses() {

        List<WhereHouse> warehouseList = warehouseRepository.findAll();
        return warehouseList;
    }

    public Result editWarehouse(Integer warehouseId, WhereHouse warehouse) {

        Optional<WhereHouse> optionalWarehouse = warehouseRepository.findById(warehouseId);
        if (!optionalWarehouse.isPresent())
            return new Result("Invalid Warehouse Id", false);

        boolean existsByName = warehouseRepository.existsByName(warehouse.getName());
        if (existsByName)
            return new Result("The Warehouse name already exist!", false);

        WhereHouse editedWarehouse = optionalWarehouse.get();

        editedWarehouse.setName(warehouse.getName());
        warehouseRepository.save(editedWarehouse);
        return new Result("Warehouse edited.", true);
    }

    public Result deleteWarehouse(@PathVariable Integer warehouseId){

        Optional<WhereHouse> optionalWarehouse = warehouseRepository.findById(warehouseId);
        if (!optionalWarehouse.isPresent())
            return new Result("Invalid Warehouse Id",false);

        warehouseRepository.deleteById(warehouseId);
        return new Result("Warehouse deleted." ,true);
    }
}
