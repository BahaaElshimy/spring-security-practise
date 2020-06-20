package com.bahaa.domain;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by bahaa on 20/06/20.
 */

@Data
public class Product extends BaseEntity {
    private String name;
    private Long amount;
    private double price;

    public Product(Long id, LocalDate createdDate, LocalDate modifiedDate, String name, Long amount, double price) {
        super(id, createdDate, modifiedDate);
        this.name = name;
        this.amount = amount;
        this.price = price;
    }
}
