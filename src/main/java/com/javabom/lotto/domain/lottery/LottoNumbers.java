package com.javabom.lotto.domain.lottery;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private final List<LottoNumber> numbers;

    public final static int MAX_LOTTO_COUNTS = 6;

    public LottoNumbers(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public int getSameCountByWinnerNumber(List<LottoNumber> winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber::contains)
                .count();
    }

    public boolean hasBonusNumber(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
