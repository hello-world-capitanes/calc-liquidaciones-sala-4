package com.sala4.liquidations.models.dto;

import lombok.Data;

@Data
public class DamagesDTO {

    private Long damageId;
    private Long sinisterId;

    private String description;
}
