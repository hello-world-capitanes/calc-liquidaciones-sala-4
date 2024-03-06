package com.sala4.liquidations.models;

import lombok.Data;

import java.util.List;

@Data
public class Product {
    private String code;
    private String name;
    private String company;

    List<ProductWarranty> productWarranties;
    private List<Double> baseCapitalList;

}
