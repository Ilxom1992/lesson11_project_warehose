package com.example.demo.entity;

import com.example.demo.constant.ExpireStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InputProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Product product;
    @Column(nullable = false)
    private Double amount;
    private Date expireDate;
    private Double price;
    @ManyToOne
    private  Input input;
    @Column(name="expire_status")
    @Enumerated(EnumType.ORDINAL)
    private ExpireStatus expireStatus;
}
