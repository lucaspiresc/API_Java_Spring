package com.inter.desafioInter.Entities;

import java.util.List;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name="DigitUser")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String username;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String email;

    @OneToMany(mappedBy = "user", cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}, orphanRemoval = true)
    private List<UniqueDigit> uniqueDigits;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
