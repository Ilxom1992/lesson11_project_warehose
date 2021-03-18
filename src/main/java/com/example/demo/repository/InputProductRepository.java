package com.example.demo.repository;

import com.example.demo.entity.InputProduct;
import com.example.demo.payload.DailyTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface InputProductRepository  extends JpaRepository<InputProduct,Integer> {
@Query("select new com.example.demo.payload.DailyTotal( sum(ip.amount) , sum(ip.price))  from InputProduct ip  where ip.input.date between :startDate and :endDate")
DailyTotal findDailyInput(Date startDate,Date endDate);
@Query(value = "select * from input_product where expire_status=0 and  expire_date between  now()  and :after10",nativeQuery = true)
List<InputProduct>getWarningProducts(Date after10);
@Query(value = "select count() from input_product where expire_status=1",nativeQuery = true)
List<InputProduct> findAllByExpireStatus(Integer status);


}
