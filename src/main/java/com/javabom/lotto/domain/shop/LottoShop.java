package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.ticket.LottoNumber;
import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoTickets;
import com.javabom.lotto.domain.vo.Money;

import java.util.ArrayList;
import java.util.List;


public class LottoShop {

    public final static Money TICKET_PRICE = new Money(1000);
    private final LottoNumbersGenerator numberGenerator;

    public LottoShop(LottoNumbersGenerator generator) {
        this.numberGenerator = generator;
    }


    public LottoTickets buyTicketsByAutomaticInLottoShop(Money money) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        Money currentMoney = money;

        while (currentMoney.canSpendMoney(TICKET_PRICE)) {
            lottoTickets.add(generateTicket());
            currentMoney = currentMoney.spendMoney(TICKET_PRICE);
        }

        return new LottoTickets(lottoTickets);
    }

    private LottoTicket generateTicket() {
        return new LottoTicket(numberGenerator.generate());
    }

    public LottoTickets buyTicketsByManualInLottoShop(List<List<LottoNumber>> manualLottoNumbers) {
        List<LottoTicket> manualTickets = new ArrayList<>();

        for (List<LottoNumber> lottoNumber : manualLottoNumbers) {
            manualTickets.add(giveLottoTicket(lottoNumber));
        }

        return new LottoTickets(manualTickets);
    }

    private LottoTicket giveLottoTicket(List<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public Money getRemainMoney(LottoTickets lottoTickets, Money money) {
        int price = lottoTickets.size() * TICKET_PRICE.getValue();

        return money.spendMoney(new Money(price));
    }
}
