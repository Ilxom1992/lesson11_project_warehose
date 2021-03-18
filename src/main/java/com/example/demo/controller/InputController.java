package com.example.demo.controller;

import com.example.demo.entity.Input;
import com.example.demo.payload.InputDTO;
import com.example.demo.payload.Result;
import com.example.demo.servise.InputService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/input")
public class InputController {

    final InputService inputService;

    public InputController(InputService inputService) {
        this.inputService = inputService;
    }


    @PostMapping(value = "/upload")
    public Result addInput(@RequestBody InputDTO inputDTO){

        Result result = inputService.addInput(inputDTO);
        return result;
    }

    @GetMapping(value = "/get")
    public Page<Input> inputList(@PathVariable Integer page){

        Page<Input> inputList = inputService.inputList(page);
        return inputList;
    }
    @PutMapping(value = "/edit/{inputId}")
    public Result editInput(@PathVariable Integer inputId, @RequestBody InputDTO inputDTO){

        Result result = inputService.editInput(inputId, inputDTO);
        return result;
    }

    @DeleteMapping(value = "/delete/{inputId}")
    public Result deleteInput(@PathVariable Integer inputId){

        Result result = inputService.deleteInput(inputId);
        return result;
    }
}
