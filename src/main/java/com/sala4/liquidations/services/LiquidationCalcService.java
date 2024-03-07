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
            if(!warranty.isExcluded()) {
                double warrantyAmount = liquidationCalculationByAssessment(warranty);
                warrantyAmount = calculateOverinsurance(warranty,warrantyAmount);
                totalAmount+=warrantyAmount;
            }
        }
        return totalAmount;
    }

    private double calculateOverinsurance(ProductWarranty warranty, double warrantyAmount) {
        double totalInsurance = warranty.getCapitalInsured();
        if(totalInsurance < warranty.getRisk().getRealValueContent()){
            double excessRatio = (warranty.getRisk().getRealValueContent() - totalInsurance) / warranty.getRisk().getRealValueContent();
            totalInsurance *= (1 - excessRatio);
        }
        return totalInsurance;
    }

    private double liquidationCalculationByAssessment(ProductWarranty warranty) {
        double amountToLiquidation=0;
        switch (warranty.getPaymentType()){
            case PRIMER_RIESGO:
                amountToLiquidation= warranty.getCapitalInsured();
                break;
            case REPOSICION_NUEVO:
                amountToLiquidation = warranty.getNewArticleValue();
                break;
            case VALOR_REAL:
                amountToLiquidation = calculateRealValue(warranty);
                break;
        }
        return amountToLiquidation;
    }

    private double calculateRealValue(ProductWarranty warranty) {
        double initialCost = warranty.getPurchaseValue();
        double yearAge = warranty.getAgeYears();

        double deprecationPercentage= 1.0 / 7.0;
        for (int i =0 ; i < yearAge; i++){
            initialCost*=(1- deprecationPercentage);
        }

        double residualValue = initialCost * 0.1;
        return Math.max(residualValue,initialCost);
    }
}
