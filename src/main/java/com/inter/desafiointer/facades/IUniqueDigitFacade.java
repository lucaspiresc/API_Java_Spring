package com.inter.desafiointer.facades;

import com.inter.desafiointer.dto.UniqueDigitDTO;
import java.util.List;

public interface IUniqueDigitFacade {

    List<UniqueDigitDTO> getUniqueDigitsByUserId(Long userId);

    Long calculateUniqueDigit(Long value, Long multiplier, Long userId);

    Long addNumbers(Long value);

    void insertDigit(Long value, Long multiplier, Long result, Long userId);

}
