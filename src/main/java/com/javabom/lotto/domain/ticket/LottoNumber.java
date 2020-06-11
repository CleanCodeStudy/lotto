package com.javabom.lotto.domain.ticket;

import java.util.Objects;

public class LottoNumber {

    private final int number;
    public final static int NUMBER_BEGIN = 1;
    public final static int NUMBER_END = 45;


    public LottoNumber(int number) {
        this.number = number;
        validLottoNumber();
    }

    public int getNumber() {
        return this.number;
    }

    private void validLottoNumber() {
        if (number < NUMBER_BEGIN || number > NUMBER_END) {
            throw new IllegalArgumentException(String.format("로또 번호가 아닙니다. - %s", number));
        }

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
