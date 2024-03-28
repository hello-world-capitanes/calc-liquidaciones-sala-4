package com.sala4.liquidations.models;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
public class Warranty {

    @Id
    private String code;

    private String name;

    @Enumerated(EnumType.STRING)
    private WarrantyType warrantyType;

    // Otros atributos y métodos si es necesario
}