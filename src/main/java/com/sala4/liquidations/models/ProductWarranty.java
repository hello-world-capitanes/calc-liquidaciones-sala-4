package com.sala4.liquidations.models;


import lombok.Data;

@Data
public class ProductWarranty {
    private Risk risk;
    private String name;
    private Warranty warranty;
    private boolean excluded;
    private PaymentType paymentType;
    private double capitalInsured;
    private double newArticleValue;
    private double purchaseValue;
    private int ageYears;

    public ProductWarranty(String name, String warrantyCode, double newArticleValue, double purchaseValue, int ageYears) {
        this.name = name;
        this.warranty = warrantyCode;

    }
    
}
