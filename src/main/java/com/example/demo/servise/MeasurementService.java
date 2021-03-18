package com.example.demo.servise;
import com.example.demo.entity.Measurement;
import com.example.demo.payload.Result;
import com.example.demo.repository.MeasurementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
final MeasurementRepository measurementRepository;

    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }


    public Result addMeasurementService(Measurement measurement){
        boolean existsByName = measurementRepository.existsByName(measurement.getName());
        if (existsByName){
            return new Result("Bunday o'lchov birligi mavjud",false);
        }
        Measurement save = measurementRepository.save(measurement);
        return new
                Result("Muafaqiyatli saqlandi",true);
    }
    //READ
    public List<Measurement> get(){
return measurementRepository.findAll();
    }
    //UPDATE
    public Result edit(Measurement measurement,Integer id){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (!optionalMeasurement.isPresent()){
            return  new Result("Bunday id li o`lchov birligi mavjud emas",false);
        }
        Measurement measurement1=new Measurement();
        measurement1.setName(measurement.getName());
        measurement1.setActive(measurement.isActive());
        measurementRepository.save(measurement1);
        return new Result("Measurement O'zgartirildi",true);
    }
    //DELETE
    public Result delete(Integer id){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (!optionalMeasurement.isPresent()){
            return new Result("Bunday id li mesurement mavjud emas",false);
        }
        measurementRepository.deleteById(id);
        return new Result("Bu Id O'lchov birligi o'chirildi",true);
    }
    //READ BY ID
    public Result getById(Integer id){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (!optionalMeasurement.isPresent()){
            return new Result("Bu Id O'lchov birligi mavjud emas",false);
        }
         return new Result("Bu Id O'lchov birligi ",true,optionalMeasurement);
    }


}
