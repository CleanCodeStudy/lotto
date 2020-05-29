package com.javabom.lotto.domain.ticket;

import java.util.Objects;

public class Money {

    private final long money;

    public Money(long money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(long money) {
        if (money < 0) {
            throw new IllegalArgumentException("돈은 음수일 수 없습니다.");
        }
    }

    public int calculateQuantityPer(int price) {
        return (int) money / price;
    }

    public double calculateRatioOf(Money input) {
        return (double) input.money / this.money * 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
