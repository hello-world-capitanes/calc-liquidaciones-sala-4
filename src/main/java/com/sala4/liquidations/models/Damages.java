package com.sala4.liquidations.models;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
public class Damages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long damageId;

    private String description;

    /*@ManyToOne
    private ProductWarranty productWarranty;*/
    @ManyToOne
    private Sinister sinister;
}
