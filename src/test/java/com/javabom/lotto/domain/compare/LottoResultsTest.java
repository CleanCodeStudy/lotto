package com.javabom.lotto.domain.compare;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.javabom.lotto.domain.compare.LottoResult.FIFTH_PRIZE;
import static com.javabom.lotto.domain.compare.LottoResult.FOURTH_PRIZE;
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
        List<LottoResult> expectedLottoResultList = lottoResultList.stream()
                .filter(result -> result == FOURTH_PRIZE)
                .collect(Collectors.toList());

        // then
        assertThat(lottoResults.findResultsOf(FOURTH_PRIZE))
                .isEqualTo(expectedLottoResultList);
    }

    @Test
    void getTotalPrizeMoney() {
        // given
        List<LottoResult> lottoResultList = Arrays.asList(
                FOURTH_PRIZE,
                FOURTH_PRIZE,
                FIFTH_PRIZE);
        LottoResults lottoResults = new LottoResults(lottoResultList);
        long expectedTotalPrizeMoney = lottoResultList.stream()
                .mapToLong(LottoResult::getPrice)
                .sum();

        // then
        assertThat(lottoResults.getTotalPrizeMoney())
                .isEqualTo(expectedTotalPrizeMoney);
    }
}