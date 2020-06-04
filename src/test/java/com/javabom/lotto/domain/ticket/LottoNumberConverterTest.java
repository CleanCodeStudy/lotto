package com.javabom.lotto.domain.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberConverterTest {

    @DisplayName("정수 리스트를 로또 넘버 리스트로 제대로 변환하는 지 검사")
    @Test
    void convert() {
        // given
        List<Integer> stubNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<LottoNumber> expectedLottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );

        // then
        assertThat(LottoNumberConverter.convert(stubNumbers))
                .isEqualTo(expectedLottoNumbers);
    }
}