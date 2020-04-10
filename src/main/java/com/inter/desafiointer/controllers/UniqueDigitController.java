package com.inter.desafiointer.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import com.inter.desafiointer.facades.IUniqueDigitFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.inter.desafiointer.dto.CalculateDigitRequestDTO;
import com.inter.desafiointer.dto.UniqueDigitDTO;
import java.util.List;

@RestController
@RequestMapping(value="api/digits")
@Api(value = "Controller de Digitos Unicos")
public class UniqueDigitController {

    @Autowired
    private IUniqueDigitFacade uniqueDigitFacade;

    @PostMapping("/calculate")
    @ApiOperation(value = "Calcula um digito unico com base nos parametros, e associa a um usuario caso o parametro do ID esteja preenchido")
    public ResponseEntity calculateDigit(@RequestBody CalculateDigitRequestDTO request){
        try {
            Long result = uniqueDigitFacade.calculateUniqueDigit(request.getNumberValue(), request.getMultiplier(), request.getUserId());
            return ResponseEntity.ok("Unique number: " + result);
        }
        catch (Exception ex) {
            //log error ?
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/user/{userId}")
    @ApiOperation(value = "Recupera todos os calculos de digito associados a um determinado usuario")
    public ResponseEntity getUniqueDigitsByUserId(@PathVariable Long userId){
        try{
            List<UniqueDigitDTO> uniqueDigitsDTO = uniqueDigitFacade.getUniqueDigitsByUserId(userId);
            if(!uniqueDigitsDTO.isEmpty()){
                return ResponseEntity.ok(uniqueDigitsDTO);
            }
            else{
                return ResponseEntity.badRequest().body("Unable to find any unique digits");
            }
        }
        catch (Exception ex){
            //log error ?
            return ResponseEntity.badRequest().build();
        }
    }

}
