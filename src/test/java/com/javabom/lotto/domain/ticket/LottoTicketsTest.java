package com.javabom.lotto.domain.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @DisplayName("두 일급 컬렉션 합치기")
    @Test
    void add() {
        // given
        LottoTicket ticket1 = new LottoTicket(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        LottoTicket ticket2 = new LottoTicket(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(7),
                new LottoNumber(8)
        ));
        LottoTickets lottoTickets1 = new LottoTickets(Arrays.asList(ticket1));
        LottoTickets lottoTickets2 = new LottoTickets(Arrays.asList(ticket2));

        // when
        LottoTickets addedLottoTickets = lottoTickets1.add(lottoTickets2);

        // then
        assertThat(addedLottoTickets.get()).isEqualTo(Arrays.asList(ticket1, ticket2));

    }
}