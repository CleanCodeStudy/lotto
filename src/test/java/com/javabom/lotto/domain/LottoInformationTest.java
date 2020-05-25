package com.javabom.lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoInformationTest {

    @ParameterizedTest
    @DisplayName("정수가 값과 음수 값이 들어올 시 예외처리.")
    @CsvSource(value = {"error,-1"})
    public void validIntegerValue(String notInteger, String negativeValue) {
        assertThatThrownBy(() -> new LottoInformation(notInteger))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("정수가 아닌 값이 입력 되었습니다.");

        assertThatThrownBy(() -> new LottoInformation(negativeValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입금액이 음수 값으로 입력되었습니다.");
    }

    @Test
    @DisplayName("입력된 GameMoney 잘 가지고 있는지 확인.")
    public void getGameMoneyTest() {
        // given
        String gameMoney = "14000";
        LottoInformation info = new LottoInformation(gameMoney);

        Assertions.assertEquals(Integer.parseInt(gameMoney), info.getGameMoney());
    }
}