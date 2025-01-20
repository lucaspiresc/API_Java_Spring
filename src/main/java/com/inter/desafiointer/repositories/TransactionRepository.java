package com.inter.desafiointer.repositories;

import com.inter.desafiointer.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
