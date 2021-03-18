package com.example.demo.controller;

import com.example.demo.entity.Measurement;
import com.example.demo.payload.Result;
import com.example.demo.repository.MeasurementRepository;
import com.example.demo.servise.MeasurementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    final MeasurementService measurementService;
    final MeasurementRepository measurementRepository;
    public MeasurementController(MeasurementService measurementService, MeasurementRepository measurementRepository) {
        this.measurementService = measurementService;
        this.measurementRepository = measurementRepository;
    }
    @PostMapping
    public Result addMeasurement(@RequestBody Measurement measurement){
        return measurementService.addMeasurementService(measurement);
    }
    //READ
    @GetMapping
    public List<Measurement>get(){
        return measurementService.get();
    }
    //UPDATE
    @PutMapping(value = "/edit{id}")
    public Result edit(@RequestBody Measurement measurement,Integer id){
return measurementService.edit(measurement,id);
    }
    //DELETE
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id){
return measurementService.delete(id);
    }
    //READ BY ID
    @GetMapping(value = "/{id}")
    public Result getById(@PathVariable Integer id){
return measurementService.getById(id);
    }
}
