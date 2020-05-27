package com.javabom.lotto.domain.valid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @DisplayName("들어온 번호가 숫자가 아닐시 NumberFormatException 을 발생시킨다.")
    @Test
    void parseInt1() {
        assertThatThrownBy(() -> new Number("String"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 값이 들어왔습니다.");
    }

    @DisplayName("들어온 번호가 숫자면 오류가 나지 않는다.")
    @Test
    void parseInt2() {
        Number number = new Number("10");
        assertThat(number.get()).isEqualTo(10);
    }
}