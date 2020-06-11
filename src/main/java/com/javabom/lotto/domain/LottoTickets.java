package com.javabom.lotto.domain;

import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoWinningTicket;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoResult matchAllLotto(LottoWinningTicket lottoWinningTicket) {
        return lottoTickets.stream()
                .map(lottoWinningTicket::findMatchingSheet)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoResult::new));
    }

    public List<LottoTicket> getAllTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
