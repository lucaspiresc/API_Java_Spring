package com.inter.desafiointer.entities;

import com.inter.desafiointer.entities.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Transactions")
public class Transactions {

    @Id
    private Long transactionId;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private Long destinationWallet;

    private Long transactionAmount;

    @ManyToOne
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;
}
