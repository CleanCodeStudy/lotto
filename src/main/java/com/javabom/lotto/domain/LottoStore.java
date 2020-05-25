package com.javabom.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int TICKET_PRICE = LottoTicket.PRICE;
    private final LottoTicketGenerator lottoTicketGenerator;

    public LottoStore(LottoTicketGenerator lottoTicketGenerator) {
        this.lottoTicketGenerator = lottoTicketGenerator;
    }

    public LottoTickets buyTickets(final int price) {
        int currentChange = price;

        List<LottoTicket> tickets = new ArrayList<>();

        while (isEnoughChange(currentChange)) {
            tickets.add(lottoTicketGenerator.generate());
            currentChange -= TICKET_PRICE;
        }

        return new LottoTickets(tickets);
    }

    public LottoGameResult askLottoGameResult(LottoTickets lottoTickets, WinningResult winningResult) {
        return lottoTickets.calculateResult(winningResult);
    }

    private boolean isEnoughChange(int currentChange) {
        return currentChange >= TICKET_PRICE;
    }
}
