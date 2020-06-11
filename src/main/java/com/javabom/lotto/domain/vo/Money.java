package com.javabom.lotto.domain.vo;

public class Money {

    private final int value;

    public Money(int value) {
        this.value = value;
    }

    private void checkSpendMoney(Money money) {
        if (this.getValue() < money.getValue()) {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
    }

    public Money spendMoney(Money price) {
        checkSpendMoney(price);
        return new Money(value - price.getValue());
    }

    public boolean canSpendMoney(Money price) {
        return this.getValue() >= price.getValue();
    }

    public int getValue() {
        return value;
    }
}
