package com.southwind.entity;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private long id;
    private String name;
    private List<Goods> goods;
}
