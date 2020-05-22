package com.javabom.lotto.domain;

import java.util.List;

public class FixedLottoNumberGenerator implements NumberShuffler {

    List<Integer> numbers;

    public FixedLottoNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }
}
