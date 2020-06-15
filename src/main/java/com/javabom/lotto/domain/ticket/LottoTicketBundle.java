package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.number.PrizeNumbersBundle;
import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.result.LottoResultBundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LottoTicketBundle {

    private final List<LottoTicket> lottoTicketBundle;

    public LottoTicketBundle(List<LottoTicket> LottoTicketBundle) {
        this.lottoTicketBundle = LottoTicketBundle;
    }

    public LottoResultBundle getLottoResults(PrizeNumbersBundle prizeNumberBundle) {
        List<LottoResult> lottoResults = lottoTicketBundle.stream()
                .map(prizeNumberBundle::getLottoResult)
                .collect(Collectors.toList());

        return new LottoResultBundle(lottoResults);
    }

    public List<LottoTicket> get() {
        return Collections.unmodifiableList(lottoTicketBundle);
    }
}
