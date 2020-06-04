package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.dto.MoneyDto;
import com.javabom.lotto.domain.ticket.LottoNumber;
import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoShopTest {

    @Test
    @DisplayName("로또 번호를 적힌 티켓번호를 반환하는지 확인.")
    void giveTicketTest() {
        Set<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        LottoShop lottoShop = new LottoShop(new LottoNumberShuffler());
        LottoTicket giveLottoTicket = lottoShop.giveLottoTicket(lottoNumbers);

        assertEquals(lottoTicket, giveLottoTicket);
    }

    @Test
    @DisplayName("자동으로 로또 번호 6개를 성생해 티켓을 반환하는지 확인.")
    void generateTicketTest() {
        LottoShop lottoShop = new LottoShop(new LottoNumberShuffler());
        LottoTicket generateTicket = lottoShop.generateTicket();

        assertEquals(6, generateTicket.getNumbers().size());
    }
}