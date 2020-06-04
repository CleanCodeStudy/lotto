package com.javabom.lotto.domain.dto;

public class LottoNumberValidator {

    public final static int NUMBER_BEGIN = 1;
    public final static int NUMBER_END = 45;

    private static void validNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("정수가 아닌 값이 입력 되었습니다.");
        }
    }

    public static void validLottoNumber(String number) {
        validNumberFormat(number);
        if (Integer.parseInt(number) < NUMBER_BEGIN || Integer.parseInt(number) > NUMBER_END) {
            throw new IllegalArgumentException("로또 번호가 아닙니다.");
        }
    }

    public static void validLottoNumber(int number) {
        if (number < NUMBER_BEGIN || number > NUMBER_END) {
            throw new IllegalArgumentException("로또 번호가 아닙니다.");
        }

    }
}