package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.Customer;
import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoTicketBundle;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoShop {

    private final LottoMachine lottoMachine;

    public LottoShop(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public LottoTicketBundle buy(Customer customer) {
        List<LottoTicket> manualLottoTickets = lottoMachine.createManualLottoTicket(customer.getManualLottoNumbers());
        List<LottoTicket> autoLottoTickets = lottoMachine.createAutoLottoTicket(customer.getAutoLottoTicketCount());
        return new LottoTicketBundle(Stream.concat(manualLottoTickets.stream(), autoLottoTickets.stream())
                .collect(Collectors.toList()));
    }
}
