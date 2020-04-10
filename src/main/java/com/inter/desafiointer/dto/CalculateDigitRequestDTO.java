package com.inter.desafiointer.dto;

import lombok.Data;

@Data
public class CalculateDigitRequestDTO {

    private Long numberValue;
    private Long multiplier;
    private Long userId;

    public CalculateDigitRequestDTO(){
         //Empty constructor required for Model Mapper
    }
}
