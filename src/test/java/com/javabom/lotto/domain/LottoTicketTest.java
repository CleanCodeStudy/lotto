package com.javabom.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    static Stream<Arguments> lottoTickets() {
        return Stream.of(
                Arguments.of(Arrays.asList(1)),
                Arguments.of(Arrays.asList(1, 2)),
                Arguments.of(Arrays.asList(1, 2, 3)),
                Arguments.of(Arrays.asList(1, 2, 3, 4)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @DisplayName("LottoTicket에 숫자를 추가하면 Exception을 던진다")
    @Test
    void lottoImmutable() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> lottoTicket.getLottoNumbers().add(7))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("LottoTicket에 6개가 아닌 숫자리스트로 초기화하면 Exception을 던진다")
    @MethodSource(value = "lottoTickets")
    @ParameterizedTest
    void overSix(List<Integer> lotto) {
        assertThatThrownBy(() -> new LottoTicket(lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또숫자는 6개로 이루어져야합니다!");
    }

}
