package com.sala4.liquidations.models;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
public class Risk {

    @Id
    private String code;

    private String name;
    private String ocurrenceDate;
    private String originCause;
    @ManyToOne
    private Policy policyAssociated;
    private double realValueContent;
    private double realValueContinent;

    // Otros atributos y métodos si es necesario
}
