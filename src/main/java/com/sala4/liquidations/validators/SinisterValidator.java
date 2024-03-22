package com.sala4.liquidations.validators;

import com.sala4.liquidations.models.dto.SinisterDTO;
import com.sala4.liquidations.models.dto.SinisterRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import javax.validation.constraints.Null;

@Component
public class SinisterValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return SinisterDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SinisterRequest sinisterRequest = (SinisterRequest) target;


        if (sinisterRequest.getRiskId() == null) {
            errors.rejectValue("riskId", "Error.sinister.riskId.required");
        }else{
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "riskId", "Error.sinister.riskId.notEmpty");
        }
        if (sinisterRequest.getPolicyId() == null) {
            errors.rejectValue("policyId", "Error.sinister.policyId.required");
        }else{
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "policyId", "Error.sinister.policyId.notEmpty");
        }
        if (sinisterRequest.getOcurrencyDate() == null) {
            errors.rejectValue("ocurrencyDate", "Error.sinister.ocurrencyDate.required");
        }else{
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ocurrencyDate", "Error.sinister.ocurrencyDate.notEmpty");
        }


        if (sinisterRequest.getRiskId() != null && !sinisterRequest.getRiskId().matches("[a-zA-Z0-9]+")) {
            errors.rejectValue("riskId", "Error.sinister.riskId.invalid");
        }

        if (sinisterRequest.getPolicyId() != null && !sinisterRequest.getPolicyId().matches("[a-zA-Z0-9]+")) {
            errors.rejectValue("policyId", "Error.sinister.policyId.invalid");
        }

    }
}
