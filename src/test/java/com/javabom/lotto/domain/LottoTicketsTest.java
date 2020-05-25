package com.javabom.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTicketsTest {

    @DisplayName("당첨 번호를 입력하면 번호일치율을 알고있는 LottoGameResult를 반환한다")
    @Test
    void calculateResult() {
        //given
        LottoTickets lottoTickets = new LottoTickets(createLottoTicket());
        WinningResult winningResult = new WinningResult(Arrays.asList(4, 5, 6, 7, 8, 9));
        //when
        LottoGameResult lottoGameResult = lottoTickets.calculateResult(winningResult);

        //then
        assertAll(
                () -> assertThat(lottoGameResult.findByHitCount(3)).isEqualTo(1),
                () -> assertThat(lottoGameResult.findByHitCount(5)).isEqualTo(1)
        );
    }

    private List<LottoTicket> createLottoTicket() {
        LottoTicket lottoTicket1 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket2 = new LottoTicket(Arrays.asList(3, 4, 5, 6, 7, 8));
        LottoTicket lottoTicket3 = new LottoTicket(Arrays.asList(10, 11, 12, 13, 14, 15));

        return Arrays.asList(lottoTicket1, lottoTicket2, lottoTicket3);
    }
}
