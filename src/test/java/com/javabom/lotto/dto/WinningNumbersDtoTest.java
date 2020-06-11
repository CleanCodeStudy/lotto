package com.javabom.lotto.dto;

import com.javabom.lotto.domain.ticket.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningNumbersDtoTest {

    @DisplayName("입력받은 당첨번호 문자열 값을 로또번호 객체로 변환하는지 확인.")
    @Test
    public void convertLottoNumberTest() {
        List<String> winningNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        WinningNumbersDto winningNumbersDto = new WinningNumbersDto(winningNumbers, "3");

        List<LottoNumber> lottoNumbers = winningNumbers.stream()
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertEquals(lottoNumbers, winningNumbersDto.getWinningNumbers());
    }

    @DisplayName("입력받은 당첨번호 값에 정수가 아닌 값이 들어간 경우 예외 처리.")
    @Test
    public void validWinningNumberTest() {
        List<String> winningNumbers = Arrays.asList("1", "2", "a", "4", "5", "6");
        assertThatThrownBy(() -> new WinningNumbersDto(winningNumbers, "3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("정수가 아닌 값이 입력 되었습니다. - a");
    }

    @DisplayName("입력받은 당첨번호 값에 로또 번호 범위가 아닌 값(1~45)이 들어간 경우 예외 처리.")
    @Test
    public void validWinningNumberRangeTest() {
        List<String> winningNumbers = Arrays.asList("1", "2", "3", "4", "5", "46");
        assertThatThrownBy(() -> new WinningNumbersDto(winningNumbers, "3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호가 아닙니다. - 46");
    }

}