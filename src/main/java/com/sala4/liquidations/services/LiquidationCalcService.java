package com.sala4.liquidations.services;

import com.sala4.liquidations.models.PaymentType;
import com.sala4.liquidations.models.Product;
import com.sala4.liquidations.models.ProductWarranty;
import org.springframework.stereotype.Service;

@Service
public class LiquidationCalcService implements ILiquidationCalcService{


    @Override
    public double liquidationCalculation(Product product) {
        double totalAmount=0;
        for (ProductWarranty warranty: product.getProductWarranties()) {
            if(!warranty.isExcluded()){
                totalAmount+= liquidationCalculationByAssessment(warranty);
            }
        }
        return totalAmount;
    }

    private double liquidationCalculationByAssessment(ProductWarranty warranty) {
        double amountToLiquidation=0;
        switch (warranty.getPaymentType()){
            case PRIMER_RIESGO:
                break;
            case REPOSICION_NUEVO:
                break;
            case VALOR_REAL:
                break;
        }
        return amountToLiquidation;
    }
}
