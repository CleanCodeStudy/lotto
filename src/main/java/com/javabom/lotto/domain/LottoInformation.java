package com.javabom.lotto.domain;

public class LottoInformation {

    private final int gameMoney;
    public static final int lottoPrice = 1000;

    public LottoInformation(String gameMoney) {
        validGameMoney(gameMoney);
        this.gameMoney = Integer.parseInt(gameMoney);
    }

    private void validGameMoney(String gameMoney) {
        validNumberFormat(gameMoney);
        validNegativeNumber(gameMoney);
    }

    private void validNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("정수가 아닌 값이 입력 되었습니다.");
        }
    }

    private void validNegativeNumber(String gameMoney) {
        if (Integer.parseInt(gameMoney) < 0) {
            throw new IllegalArgumentException("구입금액이 음수 값으로 입력되었습니다.");
        }
    }

    public int getGameMoney() {
        return gameMoney;
    }
}
