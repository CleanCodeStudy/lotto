package com.javabom.lotto.domain.results;

import com.javabom.lotto.domain.ticket.LottoNumber;
import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoTickets;

import java.util.ArrayList;
import java.util.List;

public class LottoLuckyNumbers {

    private final LottoTicket basicLuckyTicket;
    private final LottoNumber bonusNumber;

    public LottoLuckyNumbers(LottoTicket basicLuckyTicket, LottoNumber bonusNumber) {
        this.basicLuckyTicket = basicLuckyTicket;
        this.bonusNumber = bonusNumber;
    }

    public LottoResults getLottoResults(LottoTickets lottoTickets) {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (LottoTicket ticket : lottoTickets.get()) {
            lottoResults.add(getLottoResult(ticket));
        }
        return new LottoResults(lottoResults);
    }

    private LottoResult getLottoResult(LottoTicket lottoTicket) {
        int matchCount = basicLuckyTicket.countMatchingNumbers(lottoTicket);
        boolean isBonusMatched = lottoTicket.isContain(bonusNumber);
        return LottoResult.find(matchCount, isBonusMatched);
    }
}
