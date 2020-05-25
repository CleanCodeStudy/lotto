package com.javabom.lotto.domain;

import com.javabom.lotto.domain.lottery.LottoNumber;
import com.javabom.lotto.domain.shop.NumberShuffler;

import java.util.List;

public class FixedLottoNumberGenerator implements NumberShuffler {

    List<LottoNumber> numbers;

    public FixedLottoNumberGenerator(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
