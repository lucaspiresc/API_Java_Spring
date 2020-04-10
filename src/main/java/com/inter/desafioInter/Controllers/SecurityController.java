package com.inter.desafioInter.Controllers;

import com.inter.desafioInter.Facades.SecurityFacade;
import com.inter.desafioInter.dto.PublicKeyDTO;
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
    private SecurityFacade securityFacade;

    @PostMapping("/key")
    @ApiOperation(value = "Registra a chave publica do usuario")
    public ResponseEntity<?> setNewKey(@RequestBody PublicKeyDTO request){
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
