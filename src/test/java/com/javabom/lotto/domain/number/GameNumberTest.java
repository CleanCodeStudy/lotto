package com.javabom.lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameNumberTest {

    @DisplayName("로또 당첨 번호에 사용될 숫자가 1-45 사이의 숫자가 아닐 시 IllegalArgumentException 을 발생시킨다.")
    @Test
    void checkRange() {
        String number = "50";
        assertThatThrownBy(() -> GameNumber.valueOf(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("입력값: %s, 당첨 번호는 1-45 숫자만 가능합니다.", number));
    }
}
