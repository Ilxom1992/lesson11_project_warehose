package com.example.demo.controller;

import com.example.demo.entity.OutputProduct;
import com.example.demo.payload.OutputProductDTO;
import com.example.demo.payload.Result;
import com.example.demo.servise.OutputProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/outputProduct")
public class OutputProductController {

    final OutputProductService outputProductService;

    public OutputProductController(OutputProductService outputProductService) {
        this.outputProductService = outputProductService;
    }


    @PostMapping(value = "/upload")
    public Result addOutputProduct(@RequestBody OutputProductDTO outputProductDTO) {

        Result result = outputProductService.addOutputProduct(outputProductDTO);
        return result;
    }

    @GetMapping(value = "/get")
    public Page<OutputProduct> getOutputProductPage(@PathVariable Integer page) {

        Page<OutputProduct> outputProducts = outputProductService.getOutputProductPage(page);
        return outputProducts;
    }

    @PutMapping(value = "/edit/{outputProductId}")
    public Result editInputProduct(@PathVariable Integer outputProductId, @RequestBody OutputProductDTO outputProductDTO) {

        Result result = outputProductService.editOutputProduct(outputProductId, outputProductDTO);
        return result;
    }

    @DeleteMapping(value = "/delete/{outputProductId}")
    public Result deleteOutputProduct(@PathVariable Integer outputProductId){

        Result result = outputProductService.deleteOutputProduct(outputProductId);
        return result;
    }

}
