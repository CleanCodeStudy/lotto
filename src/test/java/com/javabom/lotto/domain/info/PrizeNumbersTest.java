package com.javabom.lotto.domain.info;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeNumbersTest {

    @DisplayName("당첨 번호가 6개가 아닐 시 IllegalArgumentException 을 발생시킨다.")
    @Test
    void checkCount() {
        List<String> prizeNumbers = Arrays.asList("1", "2", "3", "4", "5");
        assertThatThrownBy(() -> new PrizeNumbers(prizeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 총 6개여야 합니다.");
    }

    @DisplayName("당첨 번호중 중복된 숫자가 있으면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void checkDuplicate() {
        assertThatThrownBy(() -> new PrizeNumbers(Arrays.asList("1", "2", "3", "4", "4", "5")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 모두 달라야 합니다.");
    }

    @DisplayName("당첨 번호와 로또 번호의 일치 갯수의 값을 반환한다.")
    @Test
    void getMatchedCount() {
        PrizeNumbers prizeNumbers = new PrizeNumbers(Arrays.asList("1", "3", "5", "7", "9", "11"));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(prizeNumbers.getMatchedCount(lotto)).isEqualTo(3);
    }

    @DisplayName("당첨 번호에 들어있는 번호면 true, 들어있지 않는 번호면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource({"4,true", "7,false"})
    void has(String number, boolean expected) {
        List<String> strPrizeNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        PrizeNumbers prizeNumbers = new PrizeNumbers(strPrizeNumbers);
        BonusNumber bonusNumber = new BonusNumber(number);
        assertThat(prizeNumbers.has(bonusNumber)).isEqualTo(expected);
    }
}