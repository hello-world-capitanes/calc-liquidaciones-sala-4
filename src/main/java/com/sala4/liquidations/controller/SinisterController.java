package com.sala4.liquidations.controller;

import com.sala4.liquidations.models.Damages;
import com.sala4.liquidations.models.dto.DamagesDTO;
import com.sala4.liquidations.models.dto.SinisterRequest;
import com.sala4.liquidations.services.IRegisterSinisterService;
import com.sala4.liquidations.services.SinisterService;
import com.sala4.liquidations.validators.SinisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sinister")
public class SinisterController {

    @Autowired
    private SinisterValidator sinisterValidator;
    @Autowired
    private SinisterService sinisterService;

    @PostMapping("")
    public ResponseEntity<Long> registerSinister(@Validated @RequestBody SinisterRequest sinisterRequest,
                                                   BindingResult bindingResult) {
        sinisterValidator.validate(sinisterRequest, bindingResult);
        Long idSinister = sinisterService.createSinister(sinisterRequest);
        if(bindingResult.hasErrors()){
            String errors = bindingResult.getAllErrors()
                    .stream()
                    .map(error -> error.getCode())
                    .collect(Collectors.joining(", "));
            return new ResponseEntity<>(idSinister, HttpStatus.BAD_REQUEST);

        }
        //return ok 200 with sinister created id in two separate variables like  ResponseEntity(1, ResponseEntity.ok)
        return new ResponseEntity<>(idSinister, HttpStatus.OK);
    }

    @GetMapping("/{idSinister}")
    public SinisterRequest getSinister(@PathVariable Long idSinister){
        return sinisterService.getSinister(idSinister);
    }

    @GetMapping("/{idSinister}/damages")
    public SinisterRequest getSinisterDamageList(@PathVariable Long idSinister){
        return sinisterService.getSinister(idSinister);
    }

    @PostMapping("/{idSinister}/damages")
    public boolean createSinisterDamage(@PathVariable Long idSinister, @RequestBody List<DamagesDTO> damage){
        return sinisterService.createSinisterDamage(idSinister, damage);
    }

    @GetMapping("/{idSinister}/damages/{idDamage}")
    public Damages getSinisterDamage(@PathVariable Long idSinister, @PathVariable Long idDamage){
        return sinisterService.getSinisterDamage(idSinister, idDamage);
    }

    @DeleteMapping("/{idSinister}/damages/{idDamage}")
    public boolean deleteSinisterDamage(@PathVariable Long idSinister, @PathVariable Long idDamage){
        return sinisterService.deleteSinisterDamage(idDamage);
    }


}
