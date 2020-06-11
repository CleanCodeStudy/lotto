package com.javabom.lotto.domain.number;

import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.ticket.LottoTicket;

import java.util.List;

public class PrizeNumbersBundle {

    private final PrizeNumbers prizeNumbers;
    private final GameNumber bonusNumber;

    public PrizeNumbersBundle(List<String> prizeNumbers, String bonusNumber) {
        this.prizeNumbers = new PrizeNumbers(prizeNumbers);
        this.bonusNumber = GameNumber.valueOf(bonusNumber);
        checkDuplicate();
    }

    private void checkDuplicate() {
        if (prizeNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("입력하신 보너스 번호는 당첨 번호와 겹칩니다.");
        }
    }

    public LottoResult searchResult(LottoTicket lottoTicket) {
        prizeNumbers.compareTo(lottoTicket);
        boolean bonusStatus = lottoTicket.contains(bonusNumber);
        return LottoResult.findLottoResult(lottoTicket.getMatchedCount(), bonusStatus);
    }
}
