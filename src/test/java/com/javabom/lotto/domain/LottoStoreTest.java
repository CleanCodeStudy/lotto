package com.javabom.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    @DisplayName("넣은 금액만큼 로또티켓을 발급한다")
    @Test
    void lotteryGame() {
        LottoStore lottoStore = new LottoStore(new AutoLottoTicketGenerator());

        LottoTickets lottoTickets = lottoStore.buyTickets(14000);

        assertThat(lottoTickets.getNumberOfTickets()).isEqualTo(14);
    }

}
