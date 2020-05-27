package com.javabom.lotto.domain.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberDtoTest {


    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    public void 로또번호가_아닌값_입력시_예외처리(String bonusNumber) {
        // given
        assertThatThrownBy(() -> new BonusNumberDto(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호가 아닙니다.");
    }

    @Test
    public void 정수가_아닌값_입력시_예외처리() {
        // given
        assertThatThrownBy(() -> new BonusNumberDto("error"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정수가 아닌 값이 입력 되었습니다.");
    }
}