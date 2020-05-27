package com.javabom.lotto.domain.ticket;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void 로또번호가_아닌값_입력시_예외처리(int number) {
        // given
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호가 아닙니다.");
    }
}