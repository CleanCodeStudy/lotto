package com.javabom.lotto.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("로또 결과에 대한 알맞은 상금을 반환하는지 확인한다.")
    @ParameterizedTest
    @CsvSource({"1,0", "3,5000", "4,50000", "5,1500000", "50,30000000", "6, 2000000000"})
    void getPrize(int actual, long expected) {
        LottoResult lottoResult = new LottoResult(actual);
        assertThat(lottoResult.getPrize()).isEqualTo(expected);
    }
}