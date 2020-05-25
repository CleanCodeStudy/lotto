package com.javabom.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int TICKET_PRICE = LottoTicket.PRICE;
    private final LottoTicketGenerator lottoTicketGenerator;

    public LottoGame(LottoTicketGenerator lottoTicketGenerator) {
        this.lottoTicketGenerator = lottoTicketGenerator;
    }

    public LottoTickets start(final int price) {
        int currentChange = price;

        List<LottoTicket> tickets = new ArrayList<>();

        while (isEnoughChange(currentChange)) {
            tickets.add(lottoTicketGenerator.generate());
            currentChange -= TICKET_PRICE;
        }

        return new LottoTickets(tickets);
    }

    public LottoGameResult getLottoGameResult(LottoTickets lottoTickets, WinningResult winningResult) {
        return lottoTickets.calculateResult(winningResult);
    }

    public double getRateOfProfit(LottoTickets lottoTickets, WinningResult winningResult) {
        LottoGameResult lottoGameResult = lottoTickets.calculateResult(winningResult);
        long totalReword = lottoGameResult.calculateTotalReword();
        long spentPrice = (lottoTickets.getNumberOfTickets() * TICKET_PRICE);
        return (double) totalReword / spentPrice;
    }

    private boolean isEnoughChange(int currentChange) {
        return currentChange >= TICKET_PRICE;
    }
}
