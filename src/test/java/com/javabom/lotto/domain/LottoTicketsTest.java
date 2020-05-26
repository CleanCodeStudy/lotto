package com.javabom.lotto.domain;

import com.javabom.lotto.domain.result.LottoPrize;
import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @DisplayName("당첨번호를 입력하면 당첨통계를 반환한다")
    @Test
    void resultTest() {
        //given
        LottoTickets lottoTickets = createLottoTickets();
        LottoTicket winningLottoTicket = new LottoTicket(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        List<LottoPrize> expectedLottoPrizes = Arrays.asList(LottoPrize.SIX_HIT, LottoPrize.FIVE_HIT, LottoPrize.THREE_HIT);

        //when
        LottoResult lottoResult = lottoTickets.getLottoResult(winningLottoTicket);

        //then
        assertThat(lottoResult.getLottoStatistics()).isEqualTo(expectedLottoPrizes);
    }

    private LottoTickets createLottoTickets() {
        LottoTicket lottoTicket1 = new LottoTicket(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))); // 6
        LottoTicket lottoTicket2 = new LottoTicket(new HashSet<>(Arrays.asList(7, 1, 2, 4, 5, 6))); // 5
        LottoTicket lottoTicket3 = new LottoTicket(new HashSet<>(Arrays.asList(1, 21, 3, 43, 12, 6))); // 3

        return new LottoTickets(Arrays.asList(lottoTicket1, lottoTicket2, lottoTicket3));
    }

}
