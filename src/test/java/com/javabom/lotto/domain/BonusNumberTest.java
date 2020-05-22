package com.javabom.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {

    @DisplayName("보너스 번호가 숫자가 아니면 NumberFormatException 을 발생시킨다.")
    @Test
    void parseInt() {
        PrizeNumbers prizeNumbers = new PrizeNumbers(Arrays.asList("1", "2", "3", "4", "5", "6"));
        assertThatThrownBy(() -> new BonusNumber("number", prizeNumbers))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("보너스 번호는 숫자만 들어올 수 있습니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 겹치면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void checkDuplicate1() {
        PrizeNumbers prizeNumbers = new PrizeNumbers(Arrays.asList("1", "2", "3", "4", "5", "6"));
        assertThatThrownBy(() -> new BonusNumber("6", prizeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 이미 당첨 번호에 있는 번호입니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 겹치지 않으면 오류가 나지 않는다.")
    @Test
    void checkDuplicate2() {
        PrizeNumbers prizeNumbers = new PrizeNumbers(Arrays.asList("1", "2", "3", "4", "5", "6"));
        BonusNumber actual = new BonusNumber("7", prizeNumbers);
        assertEquals(7, actual.get());

    }

    @DisplayName("보너스 번호가 1-45 사이의 숫자가 아니면 IllegalArgumentException 을 발생시킨다.")
    @Test
    void checkRange() {
        PrizeNumbers prizeNumbers = new PrizeNumbers(Arrays.asList("1", "2", "3", "4", "5", "6"));
        assertThatThrownBy(() -> new BonusNumber("50", prizeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 1부터 45까지만 있을 수 있습니다.");
    }

    @DisplayName("로또 번호중 보너스 번호를 갖고 있고 현재 일치하는 갯수가 5개면 true," +
            " 번호를 갖고 있지 않거나 현재 일치하는 갯수가 5가 아니면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource({"4,5,true", "7,5,false", "4,4,false", "7,4,false"})
    void isValid(String bonusNumber, int matchedCount, boolean expected) {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        PrizeNumbers prizeNumbers = new PrizeNumbers(Arrays.asList("10", "20", "30", "40", "12", "13"));
        BonusNumber bonus = new BonusNumber(bonusNumber, prizeNumbers);
        assertEquals(expected, bonus.isValid(lotto, matchedCount));
    }
}
