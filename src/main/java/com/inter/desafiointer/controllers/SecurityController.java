package com.inter.desafiointer.controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
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

    private Logger logger = LoggerFactory.getLogger(SecurityController.class);

    @Autowired
    private com.inter.desafiointer.facades.ISecurityFacade securityFacade;

    @PostMapping("/key")
    @ApiOperation(value = "Registra a chave publica do usuario")
    public ResponseEntity<String> setNewKey(@RequestBody com.inter.desafiointer.dto.PublicKeyDTO request){
        try{
            securityFacade.generatePublicKey(request.getPublicKey());
            return ResponseEntity.ok(request.getPublicKey());
        }
        catch (Exception ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
