package com.sala4.liquidations.models;

import lombok.Data;

import java.util.List;

@Data
public class Risk {
    private String code;
    private String name;
    private String ocurrenceDate;
    private String originCause;
    private List<ProductWarranty> damages;
    private Policy policyAssociated;
    private double realValueContent;
    private double realValueContinent;



    public double totalDamageCost(){
        return 0;
    }
}
