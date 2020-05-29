package com.javabom.lotto.domain;

import com.javabom.lotto.domain.ticket.LottoNumber;

import java.util.List;

abstract public class LottoNumbers {

    protected final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    protected abstract void validateLottoNumbers(List<LottoNumber> numbers);

    public int countMatchingNumbers(LottoNumbers lottoNumbers) {
        return (int) lottoNumbers.numbers.stream()
                .map(this.numbers::contains)
                .filter(isContain -> isContain)
                .count();
    }
}