package com.sala4.liquidations.models.dto;

import com.sala4.liquidations.models.Damages;
import lombok.Data;

import java.util.List;
@Data
public class SinisterRequest {

    private String policyId;
    private String ocurrencyDate;
    private String riskId;
    private String cause;
    private String direction;
    private List<String> damageList;

}
