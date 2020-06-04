package com.javabom.lotto.domain.dto;

import com.javabom.lotto.domain.ticket.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersDtoTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4, 5, 6  ", "1,  2,  3, 4 ,5,6"})
    @DisplayName("입력된 당첨 숫자 분리 테스트")
    public void 입력된_숫자_분리_테스트(String inputValue) {
        Set<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        WinningNumbersDto winningNumbersDto = new WinningNumbersDto(inputValue);
        Set<LottoNumber> winningNumbers = winningNumbersDto.getWinningNumbers();

        assertEquals(numbers, winningNumbers);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2, 3, 4, 5, 46", "0,1,2,4, 5, 6"})
    @DisplayName("입력된 당첨번호에 로또번호 범위 초과시 예외")
    public void 로또넘버_범위_초과_입력시_예외(String inputValue) {
        assertThatThrownBy(() -> new WinningNumbersDto(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호가 아닙니다.");

    }

    @Test
    @DisplayName("당첨번호에 중복 존재시 예외")
    public void 당첨번호_중복_존재시_예외() {
        assertThatThrownBy(() -> new WinningNumbersDto("1,2, 3, 4, 5, 5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨번호에 중복된 번호가 존재합니다.");

    }
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4", "1,2,3,4,5,6,7"})
    @DisplayName("당첨번호가 6개 이상 혹은 미만시 예외")
    public void 당첨번호가_6개가_아닐시_예외(String value) {
        assertThatThrownBy(() -> new WinningNumbersDto(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 당첨 번호 수가 6개가 아닙니다.");

    }
}