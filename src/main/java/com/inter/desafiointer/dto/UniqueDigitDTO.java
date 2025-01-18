package com.inter.desafiointer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UniqueDigitDTO {

    private Long digitId;
    private Long numberValue;
    private Long multiplier;
    private Long digitValue;
    private Long userId;
}
