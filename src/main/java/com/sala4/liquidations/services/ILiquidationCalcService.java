package com.sala4.liquidations.services;

import com.sala4.liquidations.models.Product;

public interface ILiquidationCalcService {
    double liquidationCalculation(Product product);
}
