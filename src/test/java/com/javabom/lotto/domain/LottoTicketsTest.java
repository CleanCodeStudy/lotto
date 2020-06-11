package com.javabom.lotto.domain;

import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoWinningTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
    @DisplayName("모든 로또 티켓과 당첨 번호를 비교하여 추첨 결과를 반환한다.")
    @Test
    void drawAllLotto() {
        LottoTicket ticket1 = LottoTicket.ofFixed(Arrays.asList(1, 2, 4, 3, 5, 6));
        LottoTicket ticket2 = LottoTicket.ofFixed(Arrays.asList(1, 2, 7, 3, 5, 6));
        LottoTicket ticket3 = LottoTicket.ofFixed(Arrays.asList(1, 2, 8, 3, 5, 6));
        LottoTicket ticket4 = LottoTicket.ofFixed(Arrays.asList(1, 2, 4, 3, 6, 7));

        LottoWinningTicket lottoWinningTicket = new LottoWinningTicket(Arrays.asList(1, 2, 4, 3, 5, 6), 7);

        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(ticket1, ticket2, ticket3, ticket4));

        LottoResult lottoResult = lottoTickets.matchAllLotto(lottoWinningTicket);

        LottoResult expectedResult = new LottoResult(Arrays.asList(WinningSheet.FIRST, WinningSheet.SECOND
                , WinningSheet.THIRD, WinningSheet.FOURTH));

        assertThat(lottoResult).isEqualToComparingFieldByField(expectedResult);
    }
}
