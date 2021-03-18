package com.example.demo.entity;

import com.example.demo.entity.tamplate.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Product extends AbsEntity {
    private String code;
    @ManyToOne
    private Category category;
    @OneToOne
    private Attachment photo;
    @ManyToOne
    private  Measurement measurement;



}
