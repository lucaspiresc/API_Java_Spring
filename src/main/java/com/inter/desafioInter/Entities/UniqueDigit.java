package com.inter.desafioInter.Entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Id;

@Entity
@Table(name="uniqueDigit")
public class UniqueDigit {

    @Id
    private Long digitId;

    private Long nNumber;

    private Long kNumber;

    private Long digitValue;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Long getDigitId() {
        return digitId;
    }

    public void setDigitId(Long digitId) {
        this.digitId = digitId;
    }

    public Long getnNumber() {
        return nNumber;
    }

    public void setnNumber(Long nNumber) {
        this.nNumber = nNumber;
    }

    public Long getkNumber() {
        return kNumber;
    }

    public void setkNumber(Long kNumber) {
        this.kNumber = kNumber;
    }

    public Long getDigitValue() {
        return digitValue;
    }

    public void setDigitValue(Long digitValue) {
        this.digitValue = digitValue;
    }

    public com.inter.desafioInter.Entities.User getUser() {
        return user;
    }

    public void setUser(com.inter.desafioInter.Entities.User user) {
        this.user = user;
    }
}
