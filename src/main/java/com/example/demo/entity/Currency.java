package com.example.demo.entity;

import com.example.demo.entity.tamplate.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Currency extends AbsEntity {
}
