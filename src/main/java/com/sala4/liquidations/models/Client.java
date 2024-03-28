package com.sala4.liquidations.models;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    /*
    private String address = "";
    private String phone = "";
    private String nif = "";*/

    @Enumerated(EnumType.STRING)
    private ClientType clientType;

    @OneToMany(mappedBy = "associatedClient", cascade = CascadeType.ALL)
    private List<Policy> policies;
}