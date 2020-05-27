package com.javabom.lotto.domain.info;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BonusNumberTest {

    @DisplayName("로또 번호중 보너스 번호를 갖고 있고 현재 일치하는 갯수가 5개면 true," +
            " 번호를 갖고 있지 않거나 현재 일치하는 갯수가 5가 아니면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource({"4,5,true", "7,5,false", "4,4,false", "7,4,false"})
    void isValid(String bonusNumber, int matchedCount, boolean expected) {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonus = new BonusNumber(bonusNumber);
        assertThat(bonus.isValid(lotto, matchedCount)).isEqualTo(expected);
    }
}
