package com.javabom.lotto.domain.number;

import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.utils.GameNumberConverter;

import java.util.List;

public class PrizeNumbers {

    private final List<GameNumber> prizeNumbers;

    public PrizeNumbers(List<String> strPrizeNumbers) {
        this.prizeNumbers = GameNumberConverter.convert(strPrizeNumbers);
    }

    public boolean contains(GameNumber bonusNumber) {
        return prizeNumbers.contains(bonusNumber);
    }

    public void compareTo(LottoTicket lottoTicket) {
        for (int idx = 0; idx < GameNumber.COUNT; idx++) {
            lottoTicket.match(prizeNumbers.get(idx), idx);
        }
    }
}
