package com.javabom.lotto.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("로또 결과에 대한 알맞은 상금을 반환하는지 확인한다.")
    @ParameterizedTest
    @CsvSource({"0,false,FAIL", "3,false,FIFTH", "4,false,FOURTH", "5,false,THIRD", "5,true,SECOND", "6,false,FIRST"})
    void findLottoResult(int matchedCount, boolean bonusStatus, String expected) {
        LottoResult actual = LottoResult.findLottoResult(matchedCount, bonusStatus);
        assertThat(actual).isEqualTo(LottoResult.valueOf(expected));
    }
}