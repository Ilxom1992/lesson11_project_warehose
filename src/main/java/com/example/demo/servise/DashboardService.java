package com.example.demo.servise;

import com.example.demo.dateUtil.DateUtil;
import com.example.demo.payload.DailyTotal;
import com.example.demo.repository.InputProductRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DashboardService {
final InputProductRepository inputProductRepository;

    public DashboardService(InputProductRepository inputProductRepository) {
        this.inputProductRepository = inputProductRepository;
    }
  public   DailyTotal getDashboard1(){
        Date startOfDay= DateUtil.atStartOfDay(new Date());
        Date endOfDay=DateUtil.atEndOfDay(new Date());
        return inputProductRepository.findDailyInput(startOfDay,endOfDay);
    }
}
