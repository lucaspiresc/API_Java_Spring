package com.inter.desafiointer.repositories;

import com.inter.desafiointer.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
