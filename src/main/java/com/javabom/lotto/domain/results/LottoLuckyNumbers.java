package com.javabom.lotto.domain.results;

import com.javabom.lotto.domain.ticket.LottoNumber;
import com.javabom.lotto.domain.ticket.LottoTicket;

public class LottoLuckyNumbers {

    private final LottoTicket basicLuckyTicket;
    private final LottoNumber bonusNumber;

    public LottoLuckyNumbers(LottoTicket basicLuckyTicket, LottoNumber bonusNumber) {
        this.basicLuckyTicket = basicLuckyTicket;
        this.bonusNumber = bonusNumber;
        validateDuplicatedBonusNumber();
    }

    private void validateDuplicatedBonusNumber() {
        if (this.basicLuckyTicket.isContain(bonusNumber)) {
            throw new IllegalStateException(
                    String.format("보너스 숫자 %s는 기본 당첨번호와 중복 될 수 없습니다.", bonusNumber.toString())
            );
        }
    }

    public LottoResult getLottoResult(LottoTicket lottoTicket) {
        int matchCounts = lottoTicket.countMatchingNumbers(basicLuckyTicket);
        boolean isBonusMatched = lottoTicket.isContain(bonusNumber);
        return LottoResult.find(matchCounts, isBonusMatched);
    }

}
