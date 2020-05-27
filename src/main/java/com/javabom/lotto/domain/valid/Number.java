package com.javabom.lotto.domain.valid;

public class Number {
    private int number;

    public Number(String number) {
        this.number = parseInt(number);
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 들어왔습니다.");
        }
    }

    public int get() {
        return number;
    }
}
