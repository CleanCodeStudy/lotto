package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.result.LottoRank;

import java.util.Collections;
import java.util.Set;

public class LottoTicket {

    private final Set<LottoNumber> numbers;

    public LottoTicket(Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public LottoRank findLottoRank(WinningTicket winningTicket) {
        int sameCount = (int) numbers.stream()
                .filter(winningTicket::contains)
                .count();
        boolean hasBonusNumber = numbers.stream()
                .anyMatch(winningTicket::isSameBonusNumber);

        return LottoRank.findLottoRank(sameCount, hasBonusNumber);
    }

    public Set<LottoNumber> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }
}
