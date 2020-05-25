package com.javabom.lotto.domain;

import com.javabom.lotto.domain.lottery.LottoNumber;

public class LottoNumberValidator {

    private static void validNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("정수가 아닌 값이 입력 되었습니다.");
        }
    }

    public static void validLottoNumber(String number) {
        validNumberFormat(number);
        if (Integer.parseInt(number) < LottoNumber.MIN_NUMBER || Integer.parseInt(number) > LottoNumber.MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호가 아닙니다.");
        }

    }

    public static void validLottoNumber(int number) {
        if (number < LottoNumber.MIN_NUMBER || number > LottoNumber.MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호가 아닙니다.");
        }

    }
}