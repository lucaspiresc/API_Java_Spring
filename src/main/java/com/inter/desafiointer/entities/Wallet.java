package com.inter.desafiointer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Wallet")
public class Wallet implements Serializable {

    @Id
    private Long walletId;

    private String userName;

    private Long userFunds;

    @OneToMany(mappedBy = "wallet", cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}, orphanRemoval = true)
    private List<Transactions> transactions;
}
