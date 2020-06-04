package com.javabom.lotto.domain.results;

import com.javabom.lotto.domain.ticket.LottoNumber;
import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.javabom.lotto.domain.results.LottoResult.FIRST_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;

class LottoLuckyNumbersTest {

    @DisplayName("로또 결과를 잘 계산해 내는지 확인")
    @Test
    void getLottoResults() {
        // given
        List<LottoNumber> stubLottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );

        LottoNumber bonusNumber = new LottoNumber(7);
        LottoTicket basicLuckyTicket = new LottoTicket(stubLottoNumbers);

        LottoLuckyNumbers lottoLuckyNumbers = new LottoLuckyNumbers(basicLuckyTicket, bonusNumber);

        // when
        LottoTickets allMatchLottoTicket = new LottoTickets(Arrays.asList(new LottoTicket(stubLottoNumbers)));
        LottoResults lottoResults = lottoLuckyNumbers.getLottoResults(allMatchLottoTicket);
        LottoResults expectedLottoResults = new LottoResults(Arrays.asList(FIRST_PRIZE));

        // then
        assertThat(lottoResults).isEqualTo(expectedLottoResults);
    }
}
