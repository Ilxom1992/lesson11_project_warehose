package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.payload.Result;
import com.example.demo.servise.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/client")
public class ClintController {
    final ClientService clientService;



    public ClintController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/upload")
    public Result addClient(@RequestBody Client client) {

        Result result = clientService.addClient(client);
        return result;
    }

    @GetMapping("/get")
    public Page<Client> getClients(@RequestParam Integer page) {


     return   clientService.getClients(page);
    }

    @PutMapping(value = "/edit/{clientId}")
    public Result editClient(@PathVariable Integer clientId, @RequestBody Client client) {

        Result result = clientService.editClient(clientId, client);
        return result;
    }

    @DeleteMapping(value = "/{clientId}")
    public Result deleteClient(@PathVariable Integer clientId){

        Result result = clientService.deleteClient(clientId);
        return result;
    }
}
