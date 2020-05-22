package com.javabom.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PrizeNumbersTest {

    @DisplayName("당첨 번호가 6개가 아닐 시 IllegarArgumentException 을 발생시킨다.")
    @Test
    void checkCount() {
        List<String> prizeNumbers = Arrays.asList("1", "2", "3", "4", "5");
        assertThatThrownBy(() -> new PrizeNumbers(prizeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 총 6개여야 합니다.");
    }

    @DisplayName("당첨 번호가 숫자가 아닐 시 NumberFormatException 을 발생시킨다.")
    @Test
    void parseInt() {
        List<String> prizeNumbers = Arrays.asList("1", "2", "String", "4", "5", "6");
        assertThatThrownBy(() -> new PrizeNumbers(prizeNumbers))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("당첨 번호는 숫자만 들어올 수 있습니다.");
    }

    @DisplayName("당첨 번호가 1-45 사이의 숫자가 아닐 시 IllegalArgumentException 을 발생시킨다.")
    @Test
    void getMatchedCount() {
        List<String> prizeNumbers = Arrays.asList("1", "2", "3", "4", "5", "46");
        assertThatThrownBy(() -> new PrizeNumbers(prizeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨번호는 1부터 45까지만 있을 수 있습니다.");
    }

    @DisplayName("당첨 번호에 들어있는 번호면 true, 들어있지 않는 번호면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource({"4,true", "7,false"})
    void has(int number, boolean expected) {
        List<String> strPrizeNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        PrizeNumbers prizeNumbers = new PrizeNumbers(strPrizeNumbers);
        assertEquals(expected, prizeNumbers.has(number));
    }
}