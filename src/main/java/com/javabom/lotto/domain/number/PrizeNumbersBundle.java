package com.javabom.lotto.domain.number;

import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.ticket.LottoTicket;

import java.util.List;

public class PrizeNumbersBundle {
    private static final int BONUS_ORDER = 7;

    private final PrizeNumbers prizeNumbers;
    private final OrderGameNumber bonusNumber;

    public PrizeNumbersBundle(List<String> prizeNumbers, String bonusNumber) {
        this.prizeNumbers = new PrizeNumbers(prizeNumbers);
        this.bonusNumber = OrderGameNumber.of(BONUS_ORDER, bonusNumber);
        checkDuplicate();
    }

    private void checkDuplicate() {
        if (prizeNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("입력하신 보너스 번호는 당첨 번호와 겹칩니다.");
        }
    }

    public LottoResult getLottoResult(LottoTicket lottoTicket) {
        int matchedCount = prizeNumbers.getMatchedCount(lottoTicket);
        boolean bonusStatus = lottoTicket.containsBonus(bonusNumber);
        return LottoResult.findLottoResult(matchedCount, bonusStatus);
    }
}
