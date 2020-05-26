package com.javabom.lotto.domain;


import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoTickets;
import com.javabom.lotto.vo.Money;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final Money LOTTO_TICKET_PRICE = new Money(1000);
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoStore(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public LottoTickets buy(final Money totalMoney) {
        Money currentChange = totalMoney;
        List<LottoTicket> lottoTickets = new ArrayList<>();

        while (isEnoughChange(currentChange)) {
            lottoTickets.add(new LottoTicket(lottoNumberGenerator.generate()));
            currentChange = currentChange.spend(LOTTO_TICKET_PRICE);
        }

        return new LottoTickets(lottoTickets);
    }

    private boolean isEnoughChange(Money currentChange) {
        return currentChange.isEnoughToBuy(LOTTO_TICKET_PRICE);
    }
}
