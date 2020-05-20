package com.javabom.lotto.domain.compare;

import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoTickets;

import java.util.ArrayList;

public class LottoTicketComparator {

    private final LottoLuckyNumbers luckyNumbers;

    public LottoTicketComparator(LottoLuckyNumbers luckyNumbers) {
        this.luckyNumbers = luckyNumbers;
        System.out.println(luckyNumbers.getBonusNumber().get());
    }

    public LottoResults getLottoResults(LottoTickets lottoTickets) {
        ArrayList<LottoResult> lottoResults = new ArrayList<>();
        for (LottoTicket ticket : lottoTickets.get()) {
            lottoResults.add(getLottoResult(ticket));
        }
        return new LottoResults(lottoResults);
    }

    private LottoResult getLottoResult(LottoTicket lottoTicket) {
        int count = countMatchingNumbers(lottoTicket);
        boolean isBonusMatched = lottoTicket.isContain(luckyNumbers.getBonusNumber());
        return LottoResult.find(count, isBonusMatched);
    }

    private int countMatchingNumbers(LottoTicket lottoTicket) {
        return (int) luckyNumbers.getBasicNumbers().stream()
                .map(lottoTicket::isContain)
                .filter(isContain -> isContain)
                .count();
    }
}
