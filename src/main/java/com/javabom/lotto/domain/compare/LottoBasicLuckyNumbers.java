package com.javabom.lotto.domain.compare;

import com.javabom.lotto.domain.ticket.LottoNumber;

import java.util.Collections;
import java.util.List;

public class LottoBasicLuckyNumbers {

    private static final int LUCKY_LOTTO_NUM_SIZE = 6;

    private final List<LottoNumber> numbers;

    public LottoBasicLuckyNumbers(List<LottoNumber> numbers) {
        validateLottoNumbersSize(numbers);
        this.numbers = numbers;
    }

    private void validateLottoNumbersSize(List<LottoNumber> numbers) {
        if (numbers.size() != LUCKY_LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 반드시 6개입니다.");
        }
    }

    public List<LottoNumber> get() {
        return Collections.unmodifiableList(numbers);
    }
}
