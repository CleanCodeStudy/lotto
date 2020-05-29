package com.javabom.lotto.domain.results;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoResultTest {

    @DisplayName("로또 번호 매치 가능 수는 0~6 사이임.")
    @CsvSource({"-1", "7"})
    @ParameterizedTest
    void validateMatchCount(int matchCount) {
        // then
        assertThatThrownBy(() -> LottoResult.find(matchCount, true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호 매치 수는 0~6 이외일 수 없습니다.");
    }

    @DisplayName("로또 번호 매치수와 보너스 매치여부에 따른 로또 결과 확인")
    @CsvSource({
            "6,false,FIRST_PRIZE",
            "5,true,SECOND_PRIZE",
            "5,false,THIRD_PRIZE",
            "4,false,FOURTH_PRIZE",
            "3,false,FIFTH_PRIZE",
            "2,false,LOSE",
            "1,false,LOSE",
            "0,false,LOSE",})
    @ParameterizedTest
    void find(int matchCount, boolean isBonusMatched, LottoResult expectedLottoResult) {
        // given
        LottoResult findLottoResult = LottoResult.find(matchCount, isBonusMatched);

        // then
        assertThat(findLottoResult).isEqualTo(expectedLottoResult);
    }
}