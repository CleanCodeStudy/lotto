package com.javabom.lotto.domain.ticket;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("로또번호가 아닌 1~45 이외의 수 입력못함.")
    @CsvSource({"0", "46"})
    @ParameterizedTest
    void name(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1~45이외 일 수 없습니다. 입력 값 : " + number);
    }
}