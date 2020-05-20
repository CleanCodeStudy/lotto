package com.javabom.lotto.domain.ticket;

import java.util.ArrayList;

public class LottoTicketDispenser {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoTicketDispenser(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public LottoTickets getAutoTickets(int quantity) {
        ArrayList<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            tickets.add(new LottoTicket(lottoNumberGenerator.getLottoNumbers()));
        }
        return new LottoTickets(tickets);
    }
}
