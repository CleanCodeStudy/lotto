package com.javabom.lotto.domain.ticket;

import java.util.Objects;

public class Money {

    private final long value;

    public Money(long money) {
        validateMoney(money);
        value = money;
    }

    private void validateMoney(long money) {
        if (money < 0) {
            throw new IllegalArgumentException("돈은 음수일 수 없습니다. 입력값 : " + money);
        }
    }

    public Money multiply(int value) {
        return new Money(this.value * value);
    }

    public boolean isBiggerThan(Money money) {
        return this.value > money.value;
    }

    public Money spend(Money money) {
        validateCanSpendMoney(money);
        return new Money(this.value - money.value);
    }

    private void validateCanSpendMoney(Money money) {
        if (money.value > this.value) {
            throw new IllegalArgumentException(String.format("현재 값 (%d) 보다 사용하려는 금액 (%d) 이 더 많습니다.", value, money.value));
        }
    }

    public int calculateQuantityPer(Money price) {
        return (int) (value / price.value);
    }

    public double calculateRatioOf(Money input) {
        return (double) input.value / this.value * 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return value == money1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
