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

    public ProductWarranty(Risk risk, String name, Warranty warranty, boolean excluded, PaymentType paymentType, double capitalInsured, double newArticleValue, double purchaseValue, int ageYears) {
        this.risk = risk;
        this.name = name;
        this.warranty = warranty;
        this.excluded = excluded;
        this.paymentType = paymentType;
        this.capitalInsured = capitalInsured;
        this.newArticleValue = newArticleValue;
        this.purchaseValue = purchaseValue;
        this.ageYears = ageYears;
    }

    public ProductWarranty() {

    }

    public ProductWarranty(String nombreBien, Warranty newWarranty, double valorNuevo, double valorInicial, int antiguedad) {
    }
}
