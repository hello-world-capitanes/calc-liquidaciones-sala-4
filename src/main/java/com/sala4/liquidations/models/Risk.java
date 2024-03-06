package com.sala4.liquidations.models;

import lombok.Data;

import java.util.List;

@Data
public class Risk {
    private String code;
    private String name;
    private String ocurrenceDate;
    private String originCause;
    private List<Double> damages;
    private Policy policyAssociated;
    private double realValue;
    private double purchaseValue;
    private int ageYears;


    public double totalDamageCost(){
        return damages.stream().mapToDouble(Double::doubleValue).sum();
    }
}
