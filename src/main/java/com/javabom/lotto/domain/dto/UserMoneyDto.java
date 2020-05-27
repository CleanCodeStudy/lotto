package com.javabom.lotto.domain.dto;

import com.javabom.lotto.domain.shop.LottoShop;

public class UserMoneyDto {

    private int money;

    public UserMoneyDto(String money) {
        validGameMoney(money);
        this.money = Integer.parseInt(money);
    }

    private void validGameMoney(String money) {
        validNumberFormat(money);
        validBuyLottery(money);
    }

    private void validNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("정수가 아닌 값이 입력 되었습니다.");
        }
    }

    private void validBuyLottery(String money) {
        if (Integer.parseInt(money) < LottoShop.TICKET_PRICE) {
            throw new IllegalArgumentException("로또를 구입할 금액이 부족합니다.");
        }
    }

    public int getMoney() {
        return money;
    }
}
