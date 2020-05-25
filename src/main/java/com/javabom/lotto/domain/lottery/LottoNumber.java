package com.javabom.lotto.domain.lottery;

import com.javabom.lotto.domain.LottoNumberValidator;

import java.util.Objects;

public class LottoNumber {

    private final int number;

    public final static int MIN_NUMBER = 1;
    public final static int MAX_NUMBER = 46;

    public LottoNumber(int number) {
        LottoNumberValidator.validLottoNumber(number);
        this.number = number;
    }

    public int get() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
