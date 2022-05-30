package com.foo.springsecurity.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author foo
 * @since 2022-05-30
 */
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private double price;

    @Enumerated(EnumType.STRING)
    public Currency currency;
}
