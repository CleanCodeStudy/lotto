package com.javabom.lotto.domain.compare;

import com.javabom.lotto.domain.ticket.LottoNumber;

import java.util.Collections;
import java.util.List;

public class LottoBasicLuckyNumbers {

    private final List<LottoNumber> numbers;

    public LottoBasicLuckyNumbers(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public List<LottoNumber> get() {
        return Collections.unmodifiableList(numbers);
    }
}
