package com.inter.desafioInter.Facades;

import com.inter.desafioInter.dto.UniqueDigitDTO;
import java.util.List;

public interface IUniqueDigitFacade {

    List<UniqueDigitDTO> getUniqueDigitsByUserId(Long userId);

    Long calculateUniqueDigit(Long value, Long multiplier, Long userId);

    Long addNumbers(Long value);

    void insertDigit(Long value, Long multiplier, Long result, Long userId);

}
