package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.dto.UserMoneyDto;
import com.javabom.lotto.domain.ticket.LottoTickets;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoShopTest {

    @Test
    void buyTickets() {
        UserMoneyDto userMoneyDto = new UserMoneyDto("2000");
        UserMoney userMoney = new UserMoney(userMoneyDto);
        LottoTickets lottoTickets = LottoShop.buyTickets(userMoney, new LottoNumberShuffler());
        assertEquals(2, lottoTickets.size());
    }
}