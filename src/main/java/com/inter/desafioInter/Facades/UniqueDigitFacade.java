package com.inter.desafioInter.Facades;

import com.inter.desafioInter.Entities.UniqueDigit;

public class UniqueDigitFacade {

    public UniqueDigit calculteUniqueDigit(Long value, Long multiplier){
        Long sum = addNumbers(value) * multiplier;
        Long uniqueDigit = addNumbers(sum);
        return new com.inter.desafioInter.Entities.UniqueDigit();
    }

    private Long addNumbers(Long value){
        Long sum = 0L;
        while(value > 0) {
            sum += (value % 10);
            value /= 10;
        }
        return sum;
    }


}
