package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.results.LottoLuckyNumbers;
import com.javabom.lotto.domain.results.LottoResult;
import com.javabom.lotto.domain.results.LottoResults;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public List<LottoTicket> get() {
        return Collections.unmodifiableList(tickets);
    }

    public LottoTickets add(LottoTickets lottoTickets) {
        List<LottoTicket> newTickets = new ArrayList<>();
        newTickets.addAll(this.tickets);
        newTickets.addAll(lottoTickets.tickets);
        return new LottoTickets(newTickets);
    }

    public LottoResults getLottoResults(LottoLuckyNumbers lottoLuckyNumbers) {
        return new LottoResults(tickets.stream()
                .map(lottoLuckyNumbers::getLottoResult)
                .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(tickets, that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickets);
    }
}
