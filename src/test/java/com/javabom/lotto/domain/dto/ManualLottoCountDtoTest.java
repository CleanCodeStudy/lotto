package com.javabom.lotto.domain.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ManualLottoCountDtoTest {

    @Test
    @DisplayName("음수값을 입력 했을시 예외")
    public void InputNegativeNumberTest() {
        // given
        assertThatThrownBy(() -> new ManualLottoCountDto("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수 값을 입력했습니다.");
    }

    @Test
    @DisplayName("정수가 아닌 값 입력시 예외")
    public void InputNumberFormatTest() {
        // given
        assertThatThrownBy(() -> new ManualLottoCountDto("aa"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("정수가 아닌 값이 입력 되었습니다.");
    }

}