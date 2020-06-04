package com.javabom.lotto.domain.vo;

import com.javabom.lotto.domain.dto.MoneyDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    @DisplayName("보유한 금액보다 많은 소비를 할 시 예외")
    public void validRemainMoney() {
        Money money = new Money(new MoneyDto("5000"));
        assertThatThrownBy(() -> money.spendMoney(10000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잔액이 부족합니다.");
    }

    @Test
    @DisplayName("구입한 가격만큼 소비했는지 확인.")
    void spendMoneyTest() {
        Money money = new Money(new MoneyDto("5000"));
        money.spendMoney(3000);
        assertEquals(3000, money.getSpentMoney());
    }

    @Test
    @DisplayName("잔액에 맞게 구매 가능여부 확인.")
    void canSpendMoney() {
        Money money = new Money(new MoneyDto("5000"));

        assertTrue(money.canSpendMoney(3000));
        assertFalse(money.canSpendMoney(10000));
    }
}