package com.inter.desafioInter.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inter.desafioInter.Entities.UniqueDigit;

public interface UniqueDigitRepository extends JpaRepository<UniqueDigit, Long> {
}
