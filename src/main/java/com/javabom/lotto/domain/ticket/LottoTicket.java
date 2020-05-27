package com.javabom.lotto.domain.lottery;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LottoTicket {

    private final Set<LottoNumber> numbers;

    public LottoTicket(Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public int getSameCountByWinnerNumbers(List<LottoNumber> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean hasBonusNumber(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public Set<LottoNumber> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }
}
