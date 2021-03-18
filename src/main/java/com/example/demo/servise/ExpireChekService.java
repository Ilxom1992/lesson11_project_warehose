package com.example.demo.servise;

import com.example.demo.constant.ExpireStatus;
import com.example.demo.dateUtil.DateUtil;
import com.example.demo.entity.InputProduct;
import com.example.demo.repository.InputProductRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExpireChekService {
    final InputProductRepository inputProductRepository;

    public ExpireChekService(InputProductRepository inputProductRepository) {
        this.inputProductRepository = inputProductRepository;
    }
  //  @Scheduled(cron = "0 0 8 * *")
    void checkWarningStatus(){
        Date date=DateUtil.getDateFromFuture(10);
        List<InputProduct> inputProductList = inputProductRepository.getWarningProducts(date);
        for (InputProduct inputProduct:inputProductList  ) {
            inputProduct.setExpireStatus(ExpireStatus.WARNING);
            inputProductRepository.save(inputProduct);


        }



    }




    }

