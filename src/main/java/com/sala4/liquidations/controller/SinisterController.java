package com.sala4.liquidations.controller;

import com.sala4.liquidations.models.dto.SinisterRequest;
import com.sala4.liquidations.services.IRegisterSinisterService;
import com.sala4.liquidations.validators.SinisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.stream.Collectors;

@RestController
public class SinisterController {

    @Autowired
    private IRegisterSinisterService sinisterService;
    @Autowired
    private SinisterValidator sinisterValidator;

    @PostMapping("/sinister")
    public ResponseEntity<String> registerSinister(@Validated @RequestBody SinisterRequest sinisterRequest,
                                                   BindingResult bindingResult) {
        sinisterValidator.validate(sinisterRequest, bindingResult);
        sinisterService.registerRisk(sinisterRequest);
        if(bindingResult.hasErrors()){
            String errors = bindingResult.getAllErrors()
                    .stream()
                    .map(error -> error.getCode())
                    .collect(Collectors.joining(", "));
            return ResponseEntity.badRequest().body(errors);
        }

        return ResponseEntity.ok("Sinister registered");
    }


}
