package com.javabom.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class WinningResultTest {

    @DisplayName(", 구분된 당첨번호를 입력하면 List로 분리한다")
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2,3,4,5,6"})
    @ParameterizedTest
    void makeresult(String input) {
        WinningResult winningResult = new WinningResult(input);

        assertThat(winningResult.getWinningNumbers()).contains(1, 2, 3, 4, 5, 6);
    }


}