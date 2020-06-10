package lotto.domain;

import lotto.domain.result.LottoPrize;
import lotto.domain.result.LottoResult;
import lotto.domain.result.WinningTicket;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.support.LottoNumberConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTicketsTest {

    @DisplayName("당첨번호를 입력하면 당첨통계를 반환한다")
    @Test
    void resultTest() {
        //given
        LottoTickets userTickets = createLottoTickets();
        WinningTicket winningTicket = createWinningTicket();

        //when
        LottoResult lottoResult = userTickets.getLottoResult(winningTicket);

        //then
        assertAll(
                () -> assertThat(lottoResult.countTicketsBy(LottoPrize.FIRST)).isEqualTo(1),
                () -> assertThat(lottoResult.countTicketsBy(LottoPrize.SECOND)).isEqualTo(1),
                () -> assertThat(lottoResult.countTicketsBy(LottoPrize.FIFTH)).isEqualTo(1),
                () -> assertThat(lottoResult.getRateOfProfit()).isEqualTo(676668.3333333334)
        );
    }

    private WinningTicket createWinningTicket() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        LottoTicket winningLottoTicket = new LottoTicket(new ArrayList<>(lottoNumbers));
        return new WinningTicket(winningLottoTicket, LottoNumber.of(7));
    }

    private LottoTickets createLottoTickets() {
        LottoTicket lottoTicket1 = new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 2, 3, 4, 5, 6))); // 1등
        LottoTicket lottoTicket2 = new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 2, 3, 4, 5, 7))); // 2등,
        LottoTicket lottoTicket3 = new LottoTicket(LottoNumberConverter.of(Arrays.asList(1, 21, 3, 43, 12, 6))); // 3

        return new LottoTickets(Arrays.asList(lottoTicket1, lottoTicket2, lottoTicket3));
    }


}
