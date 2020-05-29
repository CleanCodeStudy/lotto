package com.javabom.lotto.domain.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketDispenserTest {

    @DisplayName("로또 발급기가 원하는대로 로또 티켓을 발급하는지 확인")
    @Test
    void getAutoTickets() {
        // given
        List<LottoNumber> stubLottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        LottoTicketDispenser lottoTicketDispenser = new LottoTicketDispenser(() -> stubLottoNumbers);
        LottoTicket stubLottoTicket = new LottoTicket(stubLottoNumbers);
        LottoTickets expectedLottoTickets = new LottoTickets(Arrays.asList(stubLottoTicket));

        // when
        Money money = new Money(1_000);
        LottoTickets receivedLottoTicket = lottoTicketDispenser.getAutoTickets(money);

        // then
        assertThat(receivedLottoTicket).isEqualTo(expectedLottoTickets);
    }

    @DisplayName("로또 발급기가 원하는 개수의 티켓을 뽑아내는지 확인")
    @Test
    void name() {
        // given
        LottoTicketDispenser lottoTicketDispenser = new LottoTicketDispenser(new RandomLottoNumberGenerator());

        // when
        int expectedTicketQuantity = 1;
        Money money = new Money(1_000 * expectedTicketQuantity);
        LottoTickets lottoTickets = lottoTicketDispenser.getAutoTickets(money);

        // then
        assertThat(lottoTickets.get()).hasSize(expectedTicketQuantity);
    }
}