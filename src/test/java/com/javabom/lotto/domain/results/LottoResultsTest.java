package com.javabom.lotto.domain.results;

import com.javabom.lotto.domain.ticket.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.javabom.lotto.domain.results.LottoResult.FIFTH_PRIZE;
import static com.javabom.lotto.domain.results.LottoResult.FOURTH_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultsTest {

    @DisplayName("원하는 로또 결과만을 담은 List를 반환하는지 확인")
    @Test
    void findResultsOf() {
        // given
        List<LottoResult> lottoResultList = Arrays.asList(
                FOURTH_PRIZE,
                FOURTH_PRIZE,
                FIFTH_PRIZE);
        LottoResults lottoResults = new LottoResults(lottoResultList);
        List<LottoResult> expectedLottoResultList = Arrays.asList(
                FOURTH_PRIZE,
                FOURTH_PRIZE);

        // then
        assertThat(lottoResults.findResultsOf(FOURTH_PRIZE))
                .isEqualTo(expectedLottoResultList);
    }

    @Test
    void getTotalPrizeMoney() {
        // given
        List<LottoResult> lottoResultList = Arrays.asList(FOURTH_PRIZE, FIFTH_PRIZE);
        LottoResults lottoResults = new LottoResults(lottoResultList);
        Money expectedTotalPrizeMoney = new Money(FOURTH_PRIZE.getPrize() + FIFTH_PRIZE.getPrize());

        // then
        assertThat(lottoResults.getTotalPrizeMoney())
                .isEqualTo(expectedTotalPrizeMoney);
    }
}