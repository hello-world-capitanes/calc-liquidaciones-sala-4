package com.sala4.liquidations.models;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Sinister {
    private Policy policy;
    private Date ocurrencyDate;
    private String cause;
    private List<ProductWarranty> damagedList;
    private String direction;
}
