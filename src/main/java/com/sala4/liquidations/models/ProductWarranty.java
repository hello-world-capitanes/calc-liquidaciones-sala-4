package com.sala4.liquidations.models;

import lombok.Data;

import jakarta.persistence.*;

import java.util.List;

@Data
@Entity
public class ProductWarranty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Risk risk;

    private String name;

    @ManyToOne
    private Warranty warranty;

    private boolean excluded;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    private double capitalInsured;
    private double newArticleValue;
    private double purchaseValue;
    private int ageYears;

    @ManyToOne
    private Product product;
   /* @OneToMany(mappedBy = "productWarranty", cascade = CascadeType.ALL)
    private List<Damages> damages;*/
}
