package com.javabom.lotto.domain.vo;

import com.javabom.lotto.domain.valid.Number;

public class Money {
    private int money;

    public Money(String strMoney) {
        Number number = new Number(strMoney);
        this.money = number.get();
    }

    public int get() {
        return money;
    }
}
