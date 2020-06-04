package com.javabom.lotto.domain.dto;

import com.javabom.lotto.domain.ticket.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ManualLottoNumbersDtoTest {


    @DisplayName("로또번호 범위가 아닌 번호 입력시 예")
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,46"})
    public void validLottoNumberRangeTest(String inputNumbers) {
        List<String> numbers = new ArrayList<>();
        numbers.add(inputNumbers);
        assertThatThrownBy(() -> new ManualLottoNumbersDto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호가 아닙니다.");
    }

    @DisplayName("입력된 로또번호가 중 중복된 번호가 있을 시 예외")
    @Test
    public void validLottoNumberDuplicatedTest() {
        List<String> numbers = new ArrayList<>();
        numbers.add("1,2,3,4,5,5");
        assertThatThrownBy(() -> new ManualLottoNumbersDto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호 중 중복된 번호가 존재합니다.");
    }

    @DisplayName("입력된 로또번호가 6개가 아닐 시 예외")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,45,11"})
    public void validLottoNumberCountTest(String inputNumbers) {
        List<String> numbers = new ArrayList<>();
        numbers.add(inputNumbers);
        assertThatThrownBy(() -> new ManualLottoNumbersDto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 로또 번호 수가 6개가 아닙니다.");
    }

    @Test
    @DisplayName("입력한 수동 로또 번호 문자열을 분리해서 로또 번호를 생성하는지 확인")
    void getManualLottoNumbersTest() {
        List<String> numbers = new ArrayList<>();
        numbers.add("1,2,3,4,5,6");
        numbers.add("1 , 2, 3, 4 ,5, 6");

        ManualLottoNumbersDto manualLottoNumbersDto = new ManualLottoNumbersDto(numbers);
        List<Set<LottoNumber>> lottoNumbers = createLottoNumbers();
        assertEquals(lottoNumbers, manualLottoNumbersDto.getManualLottoNumbers());
    }

    List<Set<LottoNumber>> createLottoNumbers() {
        List<Set<LottoNumber>> lottNumbers = new ArrayList<>();
        Set<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        lottNumbers.add(new HashSet<>(lottoNumbers));
        lottNumbers.add(new HashSet<>(lottoNumbers));

        return lottNumbers;
    }
}