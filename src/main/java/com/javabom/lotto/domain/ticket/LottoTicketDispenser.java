package com.javabom.lotto.domain.ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketDispenser {

    public static final Money LOTTO_TICKET_PRICE = new Money(1_000);

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

    public LottoTickets getManualTickets(List<ManualLottoNumbers> manualNumbers) {
        return new LottoTickets(manualNumbers.stream()
                .map(ManualLottoNumbers::toLottoTicket)
                .collect(Collectors.toList()));
    }
}
