package com.javabom.lotto.domain.ticket;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketDispenser {

    private static final int LOTTO_TICKET_PRICE = 1_000;

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoTicketDispenser(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public LottoTickets getAutoTickets(Money inputMoney) {
        int quantity = inputMoney.calculateQuantityPer(LOTTO_TICKET_PRICE);
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            tickets.add(new LottoTicket(lottoNumberGenerator.getLottoNumbers()));
        }
        return new LottoTickets(tickets);
    }
}
