package com.example.demo.controller;

import com.example.demo.payload.ProductDto;
import com.example.demo.payload.Result;
import com.example.demo.servise.ProductService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    public Result addProduct(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }
}
