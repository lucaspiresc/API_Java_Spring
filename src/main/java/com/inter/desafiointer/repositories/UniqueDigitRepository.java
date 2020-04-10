package com.inter.desafiointer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inter.desafiointer.entities.UniqueDigit;

public interface UniqueDigitRepository extends JpaRepository<UniqueDigit, Long> {
}
