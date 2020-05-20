package com.javabom.lotto.domain.ticket;

public class LottoNumber {
    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;

    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException("로또 번호는 1~45 입니다.");
        }
    }

    public int get() {
        return number;
    }
}
