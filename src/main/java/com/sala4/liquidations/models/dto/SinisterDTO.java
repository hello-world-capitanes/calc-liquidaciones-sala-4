package com.sala4.liquidations.models.dto;

import com.sala4.liquidations.models.Damages;
import com.sala4.liquidations.models.Policy;
import com.sala4.liquidations.models.ProductWarranty;
import lombok.Data;


import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class SinisterDTO {
    /*@NotNull
    private Policy policy;*/
    private Date ocurrencyDate;
    private String risk;
    private List<Damages> damagedList;
    private String direction;
}
