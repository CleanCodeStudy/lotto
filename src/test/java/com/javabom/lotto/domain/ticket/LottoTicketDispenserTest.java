package com.javabom.lotto.domain.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        LottoTicket stubLottoTicket = new LottoTicket(stubLottoNumbers);
        LottoTicketDispenser lottoTicketDispenser = new LottoTicketDispenser(() -> stubLottoTicket);
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
        LottoTicketDispenser lottoTicketDispenser = new LottoTicketDispenser(new RandomLottoTicketGenerator());

        // when
        int expectedTicketQuantity = 1;
        Money money = new Money(1_000 * expectedTicketQuantity);
        LottoTickets lottoTickets = lottoTicketDispenser.getAutoTickets(money);

        // then
        assertThat(lottoTickets.get()).hasSize(expectedTicketQuantity);
    }

    @DisplayName("돈이 발급 해야할 티켓보다 적을 경우")
    @Test
    void validateEnoughMoney() {
        // given
        Money money = new Money(1_000);
        List<ManualLottoNumbers> stubManualNumbers = Arrays.asList(
                new ManualLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new ManualLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
        LottoTicketDispenser dispenser = new LottoTicketDispenser(new RandomLottoTicketGenerator());

        // then
        assertThatThrownBy(() -> dispenser.getManualTickets(money, stubManualNumbers))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("2개의 티켓을 사기에 돈이 모자랍니다. 넣은 금액 : 1000");
    }

    @DisplayName("수동 티켓 발급 테스트")
    @Test
    void getManualTickets() {
        // given
        Money money = new Money(1_000);
        List<ManualLottoNumbers> stubManualNumbers = Arrays.asList(
                new ManualLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
        LottoTicket stubTicket = new LottoTicket(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        LottoTickets expectedTickets = new LottoTickets(Arrays.asList(stubTicket));
        LottoTicketDispenser dispenser = new LottoTicketDispenser(new RandomLottoTicketGenerator());

        // when
        LottoTickets manualTickets = dispenser.getManualTickets(money, stubManualNumbers);

        // then
        assertThat(manualTickets).isEqualTo(expectedTickets);
    }
}