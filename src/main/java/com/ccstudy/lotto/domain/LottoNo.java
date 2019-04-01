package com.ccstudy.lotto.domain;

public class LottoNo {
    public static final int LOTTO_NUMBER_MIN_BOUND = 1;
    public static final int LOTTO_NUMBER_MAX_BOUND = 45;

    private Integer number;

    public LottoNo(Integer number) {
        validateBound(number);
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void validateBound(Integer number) {
        if (number < LOTTO_NUMBER_MIN_BOUND || number > LOTTO_NUMBER_MAX_BOUND) {
            throw new RuntimeException("로또번호는 1 ~ 45 사이의 번호여야 합니다.");
        }
    }
}
