package com.inter.desafiointer.dto;

import lombok.Data;

@Data
public class UniqueDigitDTO {

    private Long digitId;
    private Long numberValue;
    private Long multiplier;
    private Long digitValue;
    private Long userId;

    public UniqueDigitDTO(){
        //Empty constructor required for Model Mapper
    }
}
