package com.personal.arc.jaxrs.example.reqparam;

/**
 * Created by Arc on 8/1/2017.
 */
public class WalletParam {

    private Long userId;
    private Double depositMoney;
    private Double withdrawMoney;

    public Long getUserId() {
        return userId;
    }

    public WalletParam setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Double getDepositMoney() {
        return depositMoney;
    }

    public WalletParam setDepositMoney(Double depositMoney) {
        this.depositMoney = depositMoney;
        return this;
    }

    public Double getWithdrawMoney() {
        return withdrawMoney;
    }

    public WalletParam setWithdrawMoney(Double withdrawMoney) {
        this.withdrawMoney = withdrawMoney;
        return this;
    }
}
