package com.inter.desafioInter.Entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
@Table(name="DigitUser")
public class User {

    @Id
    private Long userId;

    private String name;

    private String email;

    @OneToMany(mappedBy = "user", cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}, orphanRemoval = true)
    private List<UniqueDigit> uniqueDigits;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.util.List<UniqueDigit> getUniqueDigits() {
        return uniqueDigits;
    }

    public void setUniqueDigits(java.util.List<UniqueDigit> uniqueDigits) {
        this.uniqueDigits = uniqueDigits;
    }
}
