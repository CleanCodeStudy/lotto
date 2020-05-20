package com.javabom.lotto.domain.ticket;

import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public List<LottoTicket> get() {
        return Collections.unmodifiableList(tickets);
    }
}
