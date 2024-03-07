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

    public Product(){}

    public Product(String numeroPoliza, List<ProductWarranty> bienesAfectados, double preexistenciaContenido, double preexistenciaContinente) {
    }
}
