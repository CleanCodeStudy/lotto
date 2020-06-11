package com.javabom.lotto.dto;

import com.javabom.lotto.domain.ticket.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputDtoTest {

    @Test
    @DisplayName("입력한 금액이 수동으로 구매할 금액보다 적으면 예외처리.")
    public void validMoneyTest() {
        assertThatThrownBy(() -> new InputDto("1000", "2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또를 구매할 금액이 부족합니다. - Money : 1000, Ticket Price : 2000");

    }

    @Test
    @DisplayName("음수 값이 들어올 경우 예외처리.")
    public void validNegativeValueTest() {
        // given
        assertThatThrownBy(() -> new InputDto("1000", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수 값을 입력 해주세요. - -1");
    }

    @Test
    @DisplayName("정수 값이 아닌 값이 들어올 경우 예외처리.")
    public void validNumberFormatTest() {
        // given
        assertThatThrownBy(() -> new InputDto("1000", "a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 값을 입력해주세요. - a");
    }

    @Test
    @DisplayName("입력받은 수동 로또 번호 중 중복된 번호가 있으면 예외처리.")
    void validManualNumbers() {
        InputDto inputDto = new InputDto("1000", "1");
        List<List<String>> manualNumbers = new ArrayList<>();
        List<String> manualNumber = Arrays.asList("1", "2", "3", "5", "5", "6");
        manualNumbers.add(manualNumber);

        assertThatThrownBy(() -> inputDto.setManualNumbers(manualNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호 중 중복된 번호가 존재합니다.");
    }

    @DisplayName("입력받은 수동 로또 번호가 6개가 아니면 예외처리.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void validManualNumbersCount(String inputManuals) {
        InputDto inputDto = new InputDto("1000", "1");
        List<List<String>> manualNumbers = new ArrayList<>();

        List<String> manualNumber = Arrays.asList(inputManuals.split(","));
        manualNumbers.add(manualNumber);

        assertThatThrownBy(() -> inputDto.setManualNumbers(manualNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 로또 번호 수가 6개가 아닙니다.");
    }

    @DisplayName("입력받은 수동번호의 문자열 값을 로또번호 객체로 변환하는지 확인.")
    @Test
    public void convertLottoNumberTest() {
        InputDto inputDto = new InputDto("1000", "1");
        List<List<String>> manualNumbers = new ArrayList<>();
        List<String> manualNumber = Arrays.asList("1", "2", "3", "4", "5", "6");
        manualNumbers.add(manualNumber);

        inputDto.setManualNumbers(manualNumbers);
        List<LottoNumber> convertNumbers = manualNumber
                .stream()
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertEquals(convertNumbers, inputDto.getManualNumbers().get(0));
    }

}