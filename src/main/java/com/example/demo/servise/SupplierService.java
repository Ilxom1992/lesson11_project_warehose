package com.example.demo.servise;

import com.example.demo.entity.Supplier;
import com.example.demo.payload.Result;
import com.example.demo.repository.SupplierRepository;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }
//CREATE
    public Result addSupplier(Supplier supplier){
        boolean existsByPhoneNumber = supplierRepository.existsByPhoneNumber(supplier.getPhoneNumber());
        if (existsByPhoneNumber){
            return new Result("Bunday Sotuvchi Bazada mavjud",false);
        }
        supplierRepository.save(supplier);
        return new Result("Bazaga Saqlandi",true);

    }



}
