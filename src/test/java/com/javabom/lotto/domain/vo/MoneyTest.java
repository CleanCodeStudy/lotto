package com.javabom.lotto.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.InstanceOfAssertFactories.atomicReferenceArray;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    @DisplayName("보유한 금액보다 많은 소비를 할 시 예외")
    public void validRemainMoney() {
        Money money = new Money(500);
        assertThatThrownBy(() -> money.spendMoney(new Money(10000)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잔액이 부족합니다.");
    }

    @Test
    @DisplayName("구입한 가격만큼 소비했는지 확인.")
    void spendMoneyTest() {
        Money money = new Money(5000);
        Money remainMoney = money.spendMoney(new Money(3000));
        assertEquals(new Money(2000), remainMoney);
    }

    @Test
    @DisplayName("잔액에 맞게 구매 가능여부 확인.")
    void canSpendMoney() {
        Money money = new Money(5000);

        assertTrue(money.canSpendMoney(new Money(3000)));
        assertFalse(money.canSpendMoney(new Money(10000)));
    }
}