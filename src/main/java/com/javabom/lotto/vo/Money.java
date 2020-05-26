package com.javabom.lotto.vo;

public class Money {
    private final long value;

    public Money(long value) {
        this.value = value;
    }

    public Money spend(Money money) {
        return new Money(this.value - money.value);
    }

    public boolean isEnoughToBuy(Money lottoTicketPrice) {
        return this.value >= lottoTicketPrice.value;
    }

    public long getValue() {
        return value;
    }
}
