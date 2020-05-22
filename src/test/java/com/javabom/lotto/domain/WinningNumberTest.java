package com.javabom.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningNumberTest {

    @Test
    @DisplayName("당첨 번호를 잘 반환하는지 확인.")
    public void getWinningNumberTest() {
        List<Integer> numbers = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .boxed()
                .collect(Collectors.toList());
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6", "10");

        assertEquals(numbers, winningNumber.getWinningNumber());
    }

    @Test
    @DisplayName("보너스 번호를 잘 반환하는지 확인.")
    public void getBonusNumberTest() {
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6", "10");

        assertEquals(10, winningNumber.getBonusNumber());
    }

    @Test
    @DisplayName("당첨 번호에 정수가 아닌 값이 입력된 경우 예외처리")
    public void validNotIntegerValue() {
        assertThatThrownBy(() -> new WinningNumber("1, 2, 3, 4, 5, ss", "3"))
        .isInstanceOf(NumberFormatException.class)
        .hasMessage("정수가 아닌 값이 입력 되었습니다.");
    }

    @Test
    @DisplayName("로또 번호가 아닌 번호가 입력된 경우 예외 처리.")
    public void validLottoNumbRange() {
        assertThatThrownBy(() -> new WinningNumber("1, 2, 3, 4, 5, 99", "3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호가 아닙니다.");
    }

    @ParameterizedTest
    @DisplayName("당첨 번호에 아무 값도 입력되지 않을 경우 예외처리.")
    @ValueSource(strings = {" ", ""})
    public void validEmpty(String winningNumber) {
        assertThatThrownBy(() -> new WinningNumber(winningNumber, "3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 당첨 번호가 없습니다.");
    }

    @DisplayName("입력된 당첨번호가 6개가 아닌 경우 예외처리.")
    @Test
    public void validWinningNumberCount() {
        assertThatThrownBy(() -> new WinningNumber("1, 2, 3, 4, 5, 6, 7", "3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 당첨 번호 수가 6개가 아닙니다.");
    }

    @DisplayName("중복된 당첨번호가 존재할 경우 예외처리.")
    @Test
    public void validDuplicatedWinningNumber() {
        assertThatThrownBy(() -> new WinningNumber("1, 3, 3, 4, 5, 6", "3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨번호에 중복된 번호가 존재합니다.");
    }
}