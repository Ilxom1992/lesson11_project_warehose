package com.example.demo.entity;

import com.example.demo.entity.tamplate.AbsEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class WhereHouse extends AbsEntity {
}
