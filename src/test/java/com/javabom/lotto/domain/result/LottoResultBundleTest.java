package com.javabom.lotto.domain.result;

import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.result.LottoResultBundle;
import com.javabom.lotto.domain.vo.Money;
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
                new LottoResult(4), new LottoResult(3), new LottoResult(3), new LottoResult(1), new LottoResult(1), new LottoResult(1)));

        assertThat(lottoResultBundle.calculatePrize()).isEqualTo(60000);
    }

    @DisplayName("수익률을 계산한다.")
    @ParameterizedTest
    @CsvSource({"100000,0", "10000,500"})
    void getRateOfReturn(String strMoney, int expected) {
        LottoResultBundle lottoResultBundle = new LottoResultBundle(Arrays.asList(
                new LottoResult(4), new LottoResult(3), new LottoResult(3), new LottoResult(1), new LottoResult(1), new LottoResult(1)));
        Money money = new Money(strMoney);

        assertThat(lottoResultBundle.getRateOfProfit(money)).isEqualTo(expected);
    }

    @DisplayName("로또 결과에 대한 일치 갯수를 확인한다.")
    @Test
    void getCountOfPrize() {
        LottoResultBundle lottoResultBundle = new LottoResultBundle(Arrays.asList(
                new LottoResult(4), new LottoResult(3), new LottoResult(3), new LottoResult(1), new LottoResult(1), new LottoResult(1)));

        assertThat(lottoResultBundle.getCountOfPrize(3)).isEqualTo(2);
        assertThat(lottoResultBundle.getCountOfPrize(4)).isEqualTo(1);
    }
}