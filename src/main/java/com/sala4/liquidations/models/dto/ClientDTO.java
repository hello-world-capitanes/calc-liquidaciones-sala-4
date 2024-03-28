package com.sala4.liquidations.models.dto;

import com.sala4.liquidations.models.ClientType;
import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {
    private Long id;

    private String name;
    private String address = "";
    private String phone = "";
    private String nif = "";

    private ClientType clientType;

    private List<Integer> idPolicies;
}