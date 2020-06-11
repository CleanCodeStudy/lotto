package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.number.PrizeNumbersBundle;
import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.result.LottoResultBundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketBundle {

    private final List<LottoTicket> lottoTicketBundle;

    public LottoTicketBundle(List<LottoTicket> LottoTicketBundle) {
        this.lottoTicketBundle = LottoTicketBundle;
    }

    public LottoResultBundle match(PrizeNumbersBundle prizeNumberBundle) {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTicketBundle) {
            LottoResult result = prizeNumberBundle.searchResult(lottoTicket);
            lottoResults.add(result);
        }
        return new LottoResultBundle(lottoResults);
    }

    public void addLottoTickets(List<LottoTicket> lottoTickets) {
        lottoTicketBundle.addAll(lottoTickets);
    }

    public List<LottoTicket> get() {
        return Collections.unmodifiableList(lottoTicketBundle);
    }
}
