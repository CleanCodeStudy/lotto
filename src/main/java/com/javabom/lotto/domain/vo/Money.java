package com.javabom.lotto.domain.vo;

import com.javabom.lotto.domain.dto.MoneyDto;

public class Money {

    private int money;
    private int spentMoney;

    public Money(MoneyDto moneyDto) {
        this.money = moneyDto.getMoney();
    }

    private void checkSpendMoney(int price) {
        if (this.getRemainMoney() - price < 0) {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
    }

    public void spendMoney(int price) {
        checkSpendMoney(price);
        this.spentMoney += price;
    }

    public boolean canSpendMoney(int price) {
        return this.getRemainMoney() - price >= 0;
    }

    private int getRemainMoney() {
        return this.money - this.spentMoney;
    }

    public int getSpentMoney() {
        return spentMoney;
    }
}
