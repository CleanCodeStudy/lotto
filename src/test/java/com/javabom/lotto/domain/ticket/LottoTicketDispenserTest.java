package com.javabom.lotto.domain.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketDispenserTest {

    @DisplayName("로또 발급기가 원하는대로 로또 티켓을 발급하는지 확인")
    @Test
    void getAutoTickets() {
        // given
        LottoTicketDispenser lottoTicketDispenser = new LottoTicketDispenser(new FixedLottoNumberGenerator());
        List<LottoNumber> stubLottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));
        LottoTicket stubLottoTicket = new LottoTicket(stubLottoNumbers);
        LottoTickets expectedLottoTickets = new LottoTickets(Arrays.asList(stubLottoTicket));

        // when
        LottoTickets receivedLottoTicket = lottoTicketDispenser.getAutoTickets(1);

        // then
        assertThat(receivedLottoTicket).isEqualTo(expectedLottoTickets);
    }
}