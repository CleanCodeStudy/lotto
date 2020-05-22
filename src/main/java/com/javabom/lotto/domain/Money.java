package com.javabom.lotto.domain;

public class Money {
    private final int LOTTO_PRICE = 1000;

    private int money;

    public Money(String strMoney) {
        int money = parseInt(strMoney);
        checkCanBuyLotto(money);
        this.money = money;
    }

    private int parseInt(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("금액은 숫자만 입력이 가능합니다.");
        }
    }

    private void checkCanBuyLotto(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("돈이 부족합니다. 1000원 이상 금액을 입력해 주세요.");
        }
    }

    public int getLottoCount() {
        return money / LOTTO_PRICE;
    }

    public int getRateOfProfit(int amountOfPrize) {
        int profit = amountOfPrize - money;
        if (profit < 0) {
            return 0;
        }
        return (profit / money) * 100;
    }
}
