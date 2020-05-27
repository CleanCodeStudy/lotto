package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoTickets;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    public final static int NUMBER_BEGIN = 1;
    public final static int NUMBER_END = 45;
    public final static int MAX_NUMBER_COUNT = 6;
    public static final int TICKET_PRICE = 1000;

    public static LottoTickets buyTickets(UserMoney userMoney, LottoNumberGenerator shuffler) {
        int lottoCount = userMoney.getMoney() / TICKET_PRICE;
        List<LottoTicket> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers.add(new LottoTicket(shuffler.generate()));
        }

        return new LottoTickets(lottoNumbers);
    }
}
