package com.javabom.lotto.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultBundleTest {

    @DisplayName("로또 결과에 대한 상금을 확인한다.")
    @Test
    void calculatePrize() {
        LottoResultBundle lottoResultBundle = new LottoResultBundle(Arrays.asList(
                LottoResult.FIFTH, LottoResult.FIFTH, LottoResult.FAIL, LottoResult.FOURTH));
        assertThat(lottoResultBundle.calculatePrize()).isEqualTo(60000);
    }

    @DisplayName("수익률을 계산한다.")
    @ParameterizedTest
    @CsvSource({"100000,0", "10000,500"})
    void getRateOfProfit(int amount, int expected) {
        LottoResultBundle lottoResultBundle = new LottoResultBundle(Arrays.asList(
                LottoResult.FAIL, LottoResult.FIFTH, LottoResult.FOURTH, LottoResult.FIFTH));

        assertThat(lottoResultBundle.getRateOfProfit(amount)).isEqualTo(expected);
    }

    @DisplayName("로또 결과에 대한 일치 갯수를 확인한다.")
    @Test
    void getCountOfPrize() {
        LottoResultBundle lottoResultBundle = new LottoResultBundle(Arrays.asList(
                LottoResult.FOURTH, LottoResult.FIFTH, LottoResult.FIFTH, LottoResult.FIFTH));

        assertThat(lottoResultBundle.getCountOfPrize(LottoResult.FIFTH)).isEqualTo(3);
        assertThat(lottoResultBundle.getCountOfPrize(LottoResult.FOURTH)).isEqualTo(1);
    }
}