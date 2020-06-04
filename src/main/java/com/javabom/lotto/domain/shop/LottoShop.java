package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.ticket.LottoNumber;
import com.javabom.lotto.domain.ticket.LottoTicket;

import java.util.HashSet;
import java.util.Set;

public class LottoShop {

    public final static int TICKET_PRICE = 1000;
    private final LottoNumberGenerator numberGenerator;

    public LottoShop(LottoNumberGenerator generator) {
        this.numberGenerator = generator;
    }

    public LottoTicket giveLottoTicket(Set<LottoNumber> lottoNumbers) {
        return new LottoTicket(new HashSet<>(lottoNumbers));
    }

    public LottoTicket generateTicket() {
        return new LottoTicket(numberGenerator.generate());
    }

}
