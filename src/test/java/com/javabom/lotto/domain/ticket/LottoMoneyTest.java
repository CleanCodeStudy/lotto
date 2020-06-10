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

    @DisplayName("돈 소비할 때 제대로 남는 돈이 제대로 계산 되는지 확인")
    @Test
    void spend() {
        // given
        Money money = new Money(5_000);
        Money spendMoney = new Money(2_000);
        Money expectedMoney = new Money(3_000);

        // then
        assertThat(money.spend(spendMoney)).isEqualTo(expectedMoney);
    }

    @DisplayName("남은 돈 보다 더 많은 돈을 사용할 수는 없음.")
    @Test
    void validateCanSpendMoney() {
        // given
        Money bigMoney = new Money(5_000);
        Money smallMoney = new Money(3_000);
        // then
        assertThatThrownBy(() ->smallMoney.spend(bigMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("현재 값 (3000) 보다 사용하려는 금액 (5000) 이 더 많습니다.");


    }
}