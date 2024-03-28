package com.sala4.liquidations.models;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amountCapitalContracted;

    @ManyToOne
    private Product associatedProduct;

    @ManyToOne
    private Client associatedClient;

    /*

    Comentado para hacer mas rapido el ejercicio

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)

    private List<Sinister> sinisters;*/
}
