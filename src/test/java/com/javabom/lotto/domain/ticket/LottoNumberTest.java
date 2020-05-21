package com.javabom.lotto.domain.ticket;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("생성시 넣은 숫자 잘 뱉는지 확인")
    @Test
    void get() {
        // given
        int expectedNum = 1;
        LottoNumber lottoNumber = new LottoNumber(expectedNum);

        // then
        assertThat(lottoNumber.get()).isEqualTo(expectedNum);
    }

    @DisplayName("로또번호가 아닌 1~45 이외의 수 입력못함.")
    @CsvSource({"0", "46"})
    @ParameterizedTest
    void name(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1~45 입니다.");
    }
}