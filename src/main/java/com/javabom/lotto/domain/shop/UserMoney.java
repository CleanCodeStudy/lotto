package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.dto.UserMoneyDto;

public class UserMoney {

    private int money;

    public UserMoney(UserMoneyDto userMoneyDto) {
        this.money = userMoneyDto.getMoney();
    }

    public int getMoney() {
        return money;
    }
}
