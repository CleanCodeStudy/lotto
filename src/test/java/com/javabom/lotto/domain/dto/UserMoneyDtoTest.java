package com.javabom.lotto.domain.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserMoneyDtoTest {

    @Test
    public void 구입금액_부족시_예외처리() {
        // given
        assertThatThrownBy(() -> new UserMoneyDto("500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또를 구입할 금액이 부족합니다.");
    }

    @Test
    public void 정수가_아닌값_입력시_예외처리() {
        // given
        assertThatThrownBy(() -> new UserMoneyDto("error"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정수가 아닌 값이 입력 되었습니다.");
    }
}