package com.javabom.lotto.domain.valid;

import java.util.Objects;

public class GameNumber {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;

    private int gameNumber;

    public GameNumber(String strGameNumber) {
        Number number = new Number(strGameNumber);
        checkRange(number.get());
        this.gameNumber = number.get();
    }

    private void checkRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("당첨 번호는 1-45 숫자만 가능합니다.");
        }
    }

    public int get() {
        return gameNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameNumber)) return false;
        GameNumber that = (GameNumber) o;
        return get() == that.get();
    }

    @Override
    public int hashCode() {
        return Objects.hash(get());
    }
}
