package com.example.demo.controller;

import com.example.demo.entity.Output;
import com.example.demo.payload.OutputDTO;
import com.example.demo.payload.Result;
import com.example.demo.servise.OutputService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/output")
public class OutputController {

    final OutputService outputService;

    public OutputController(OutputService outputService) {
        this.outputService = outputService;
    }


    @PostMapping(value = "/upload")
    public Result addInput(@RequestBody OutputDTO outputDTO){

        Result result = outputService.addOutput(outputDTO);
        return result;
    }

    @GetMapping(value = "/get")
    public Page<Output> outputList(@PathVariable Integer page){

        Page<Output> outputPage = outputService.outputList(page);
        return outputPage;
    }
    @PutMapping(value = "/edit/{outputId}")
    public Result editOutput(@PathVariable Integer outputId, @RequestBody OutputDTO outputDTO){

        Result result = outputService.editOutput(outputId, outputDTO);
        return result;
    }

    @DeleteMapping(value = "/delete/{outputId}")
    public Result deleteOutput(@PathVariable Integer outputId){

        Result result = outputService.deleteOutput(outputId);
        return result;
    }
}
