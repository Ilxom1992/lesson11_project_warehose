package com.example.demo.entity;

import com.example.demo.entity.tamplate.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Supplier extends AbsEntity {
    @Column(unique = true,nullable = false)
private  String phoneNumber;
}
