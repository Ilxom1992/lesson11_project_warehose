package com.example.demo.entity;

import com.example.demo.entity.tamplate.AbsEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Measurement extends AbsEntity {

}
