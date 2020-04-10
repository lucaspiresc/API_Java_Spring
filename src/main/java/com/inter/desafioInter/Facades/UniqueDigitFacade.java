package com.inter.desafioInter.Facades;

import com.inter.desafioInter.Entities.UniqueDigit;

public class UniqueDigitFacade {

    public UniqueDigit insertDigit(Long value, Long multiplier, Long UserId){
        return null;
    }

    public Long calculateUniqueDigit(Long value, Long multiplier){
        Long sum = addNumbers(value) * multiplier;
        Long uniqueDigit = addNumbers(sum);
        return uniqueDigit;
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
