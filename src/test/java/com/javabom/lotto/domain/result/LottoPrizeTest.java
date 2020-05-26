package com.javabom.lotto.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    static Stream<Arguments> lottoPrizes() {
        return Stream.of(
                Arguments.of(3, LottoPrize.THREE_HIT),
                Arguments.of(5, LottoPrize.FIVE_HIT),
                Arguments.of(6, LottoPrize.SIX_HIT),
                Arguments.of(2, LottoPrize.MISS)
        );
    }

    @DisplayName("번호일치 갯수에 따른 LottoPrize를 반환한다")
    @MethodSource("lottoPrizes")
    @ParameterizedTest
    void findLottoPrize(int matchCount, LottoPrize expectedLottoPrize) {
        //when
        LottoPrize byMathCount = LottoPrize.findByMathCount(matchCount);

        //then
        assertThat(byMathCount).isEqualTo(expectedLottoPrize);
    }

}
