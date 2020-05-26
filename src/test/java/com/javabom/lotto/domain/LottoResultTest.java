package com.javabom.lotto.domain;


import com.javabom.lotto.domain.result.LottoPrize;
import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.vo.Money;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;

class LottoResultTest {

    @DisplayName("구매금액에 따른 이익률을 반환한다")
    @Test
    void profit() {
        List<LottoPrize> statistics = createStatistics();
        LottoResult lottoResult = new LottoResult(statistics);

        assertAll(
                () -> AssertionsForClassTypes.assertThat(lottoResult.getRateOfProfit(new Money(60000))).isEqualTo(1),
                () -> AssertionsForClassTypes.assertThat(lottoResult.getRateOfProfit(new Money(120000))).isEqualTo(0.5)
        );
    }

    private List<LottoPrize> createStatistics() {
        return Arrays.asList(LottoPrize.THREE_HIT, LottoPrize.THREE_HIT, LottoPrize.FOUR_HIT);
    }

}
