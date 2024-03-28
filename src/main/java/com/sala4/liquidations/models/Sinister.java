package com.sala4.liquidations.models;

import lombok.Data;

import jakarta.persistence.*;

import java.util.List;

@Data
@Entity
public class Sinister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
    Comentado para hacer mas rapido el ejercicio
    @ManyToOne
    private Policy policy;*/

    private String ocurrencyDate;
    private String cause;
    private String direction;
    @OneToMany(mappedBy = "sinister", cascade = CascadeType.ALL)
    private List<Damages> damages;
    // Otros atributos y métodos si es necesario
}
