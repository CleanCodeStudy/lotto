package com.javabom.lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoGameResult calculateResult(WinningResult winningResult) {
        Map<Integer, Long> hitRates = lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.getHitRate(winningResult.getWinningNumbers()))
                .collect(groupingBy(Function.identity(), counting()));

        return new LottoGameResult(hitRates);
    }

    public int getNumberOfTickets() {
        return lottoTickets.size();
    }
}
