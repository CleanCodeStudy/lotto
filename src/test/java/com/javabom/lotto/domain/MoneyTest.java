package com.javabom.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("숫자가 아닌 값이 들어 왔을 시 NumberFormatException 을 발생시킨다.")
    @Test
    void parseInt() {
        assertThatThrownBy(() -> new Money("I'm String"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("금액은 숫자만 입력이 가능합니다.");
    }

    @DisplayName("금액이 1000원 이상 들어오지 않았을 시 IllegalArgumentException 을 발생시킨다.")
    @Test
    void checkCanBuyLotto() {
        assertThatThrownBy(() -> new Money("900"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("돈이 부족합니다. 1000원 이상 금액을 입력해 주세요.");
    }

    @DisplayName("금액이 1000원 이상 들어왔을 때 살 수 있는 로또 갯수를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1000,1", "14000, 14"})
    void getLottoCount(String inputValue, int expected) {
        Money money = new Money(inputValue);
        assertEquals(expected, money.getLottoCount());
    }

    @DisplayName("수익률을 계산한다.")
    @ParameterizedTest
    @CsvSource({"5000,10000,0", "20000,10000,100", "100000,10000,900"})
    void getRateOfReturn(int amountOfPrize, String strMoney, int expected) {
        Money money = new Money(strMoney);
        assertEquals(expected, money.getRateOfProfit(amountOfPrize));
    }
}