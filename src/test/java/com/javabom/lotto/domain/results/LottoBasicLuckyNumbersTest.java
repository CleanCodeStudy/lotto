package com.javabom.lotto.domain.results;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoBasicLuckyNumbersTest {

    @DisplayName("기본 당첨 번호의 개수는 6개이여야 함.")
    @CsvSource({"5", "7"})
    @ParameterizedTest
    void validateLottoNumbersSize(int size) {
        // given
        List<Integer> lottoNumbers = IntStream.rangeClosed(1, size)
                .boxed()
                .collect(Collectors.toList());

        // then
        assertThatThrownBy(() -> new LottoBasicLuckyNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 반드시 6개입니다.");
    }
}