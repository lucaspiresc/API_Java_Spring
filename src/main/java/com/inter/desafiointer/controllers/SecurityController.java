package com.inter.desafiointer.controllers;

import com.inter.desafiointer.facades.ISecurityFacade;
import com.inter.desafiointer.dto.PublicKeyDTO;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="api/security")
@Api(value = "Controller da camada de segurança")
public class SecurityController {

    @Autowired
    private ISecurityFacade securityFacade;

    @PostMapping("/key")
    @ApiOperation(value = "Registra a chave publica do usuario")
    public ResponseEntity setNewKey(@RequestBody PublicKeyDTO request){
        try{
            securityFacade.generatePublicKey(request.getPublicKey());
            return ResponseEntity.ok(request.getPublicKey());
        }
        catch (Exception ex) {
            //log error ?
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
