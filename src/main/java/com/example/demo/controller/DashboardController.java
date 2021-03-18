package com.example.demo.controller;

import com.example.demo.payload.DailyTotal;
import com.example.demo.servise.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dashboards")
public class DashboardController {
    final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/input")
    DailyTotal getDashboard(){
        return dashboardService.getDashboard1();
    }

}
