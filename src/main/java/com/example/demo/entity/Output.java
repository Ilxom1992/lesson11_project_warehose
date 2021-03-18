package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Output {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp date;
    @ManyToOne
    private WhereHouse whereHouse;
    @ManyToOne
    private Client client;

    @ManyToOne
    private  Supplier supplier;
    @ManyToOne
    private Currency currency;

    private  String  factureNumber;

    private  String code;

}
