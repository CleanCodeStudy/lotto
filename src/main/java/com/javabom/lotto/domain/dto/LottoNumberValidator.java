package com.javabom.lotto.domain.dto;

import com.javabom.lotto.domain.shop.LottoShop;

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
        if (Integer.parseInt(number) < LottoShop.NUMBER_BEGIN || Integer.parseInt(number) > LottoShop.NUMBER_END) {
            throw new IllegalArgumentException("로또 번호가 아닙니다.");
        }
    }

    public static void validLottoNumber(int number) {
        if (number < LottoShop.NUMBER_BEGIN || number > LottoShop.NUMBER_END) {
            throw new IllegalArgumentException("로또 번호가 아닙니다.");
        }

    }
}