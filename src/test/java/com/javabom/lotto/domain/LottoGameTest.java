package com.javabom.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("넣은 금액만큼 로또티켓을 발급한다")
    @Test
    void lotteryGame() {
        LottoGame lottoGame = new LottoGame(new AutoLottoTicketGenerator());

        LottoTickets lottoTickets = lottoGame.start(14000);

        assertThat(lottoTickets.getNumberOfTickets()).isEqualTo(14);
    }

    @DisplayName("로또티켓과 당첨번호를 입력하면 수익률을 반환한다")
    @Test
    void profitRate() {
        LottoGame lottoGame = new LottoGame(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoTickets lottoTickets = lottoGame.start(3000);

        double profit = lottoGame.getRateOfProfit(lottoTickets, new WinningResult(Arrays.asList(1, 2, 3, 7, 8, 9)));

        assertThat(profit).isEqualTo(5);
    }
}
