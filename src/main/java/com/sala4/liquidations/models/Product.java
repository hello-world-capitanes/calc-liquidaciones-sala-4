package com.sala4.liquidations.models;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;
    private String company;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductWarranty> productWarranties;

    // Otros atributos y métodos si es necesario
}
