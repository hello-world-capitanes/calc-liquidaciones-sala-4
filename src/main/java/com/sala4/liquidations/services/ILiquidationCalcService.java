package com.sala4.liquidations.services;

import com.sala4.liquidations.models.Risk;

public interface ILiquidationCalcService {

    Double liquidationCalculation(Risk risk);
}
