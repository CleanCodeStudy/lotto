package com.javabom.lotto.domain.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMoneyTest {

    @DisplayName("돈에 음수가 들어가면 Exception")
    @Test
    void validateMoney() {
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("돈은 음수일 수 없습니다. 입력값 : -1");
    }

    @DisplayName("인풋값에 대한 수량 가져오기")
    @Test
    void calculateQuantityPer() {
        // given
        Money money = new Money(10_000);
        Money price = new Money(1_000);
        int expectedQuantity = 10;

        // then
        assertThat(money.calculateQuantityPer(price)).isEqualTo(expectedQuantity);
    }
}