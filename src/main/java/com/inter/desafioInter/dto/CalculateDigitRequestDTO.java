package com.inter.desafioInter.dto;

import lombok.Data;

@Data
public class CalculateDigitRequestDTO {

    private Long numberValue;
    private Long multiplier;
    private Long userId;

    public CalculateDigitRequestDTO(){

    }
}
