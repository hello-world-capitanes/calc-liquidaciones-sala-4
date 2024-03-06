package com.sala4.liquidations.models;

import lombok.Data;

@Data
public class Policy{
    private double amountCapitalContracted;
    private Product asociatedProduct;
    private Client asociatedClient;

}
