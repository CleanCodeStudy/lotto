package com.javabom.lotto.domain.ticket;

import java.util.ArrayList;

public class LottoTicketDispenser {

    private static final int LOTTO_TICKET_PRICE = 1_000;

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoTicketDispenser(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public LottoTickets getAutoTickets(Money inputMoney) {
        int quantity = (int) inputMoney.get() / LOTTO_TICKET_PRICE;
        ArrayList<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            tickets.add(new LottoTicket(lottoNumberGenerator.getLottoNumbers()));
        }
        return new LottoTickets(tickets);
    }
}
