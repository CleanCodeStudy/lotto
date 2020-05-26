package com.javabom.lotto.domain;

import com.javabom.lotto.domain.compare.LottoResult;
import com.javabom.lotto.domain.compare.LottoResults;
import com.javabom.lotto.domain.ticket.LottoNumber;

import java.util.List;

abstract public class LottoNumbers {
    protected final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    protected abstract void validateLottoNumbers(List<LottoNumber> numbers);

    public LottoResults compare(LottoNumbers lottoNumbers) {
        return null;
    }

    private LottoResult getLottoResult() {
        return null;
    }
}
