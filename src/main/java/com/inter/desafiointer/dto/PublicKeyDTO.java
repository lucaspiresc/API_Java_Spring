package com.inter.desafiointer.dto;

import lombok.Data;

@Data
public class PublicKeyDTO {

    private String publicKey;

    public PublicKeyDTO(){
        //Empty constructor required for Model Mapper
    }
}
