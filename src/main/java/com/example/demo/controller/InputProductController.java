package com.example.demo.controller;

import com.example.demo.entity.InputProduct;
import com.example.demo.payload.InputProductDTO;
import com.example.demo.payload.Result;
import com.example.demo.servise.InputProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/inputProduct")

public class InputProductController {

    final InputProductService inputProductService;

    public InputProductController(InputProductService inputProductService) {
        this.inputProductService = inputProductService;
    }


    @PostMapping(value = "/upload")
    public Result addInputProduct(@RequestBody InputProductDTO inputProductDTO) {

        Result result = inputProductService.addInputProduct(inputProductDTO);
        return result;
    }

    @GetMapping(value = "/get")
    public Page<InputProduct> getInputProductPage(@PathVariable Integer page) {

        Page<InputProduct> inputProductPage = inputProductService.getInputProductPage(page);
        return inputProductPage;
    }

    @PutMapping(value = "/edit/{inputProductId}")
    public Result editInputProduct(@PathVariable Integer inputProductId, @RequestBody InputProductDTO inputProductDTO) {

        Result result = inputProductService.editInputProduct(inputProductId, inputProductDTO);
        return result;
    }

    @DeleteMapping(value = "/delete/{inputProductId}")
    public Result deleteInputProduct(@PathVariable Integer inputProductId){

        Result result = inputProductService.deleteInputProduct(inputProductId);
        return result;
    }

}
