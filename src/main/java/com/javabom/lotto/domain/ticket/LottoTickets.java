package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.result.LottoResult;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        tickets = lottoTickets;
    }

    public LottoResult getLottoResult(WinningTicket winningTicket) {
        return new LottoResult(tickets.stream()
                .map(lottoTicket -> lottoTicket.findLottoRank(winningTicket))
                .collect(Collectors.toList()));
    }
    public List<LottoTicket> getNumbers() {
        return Collections.unmodifiableList(tickets);
    }

    public int size() {
        return tickets.size();
    }
}
