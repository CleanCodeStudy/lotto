package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.result.LottoPrize;
import com.javabom.lotto.domain.result.LottoResult;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoResult getLottoResult(LottoTicket winningTicket) {
        List<LottoPrize> lottoPrizes = lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.calculateLottoPrize(winningTicket))
                .collect(toList());
        return new LottoResult(lottoPrizes);
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public int count() {
        return lottoTickets.size();
    }

    @Override
    public String toString() {
        return String.valueOf(lottoTickets);
    }
}
