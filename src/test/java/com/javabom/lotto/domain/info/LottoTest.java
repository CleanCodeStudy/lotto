package com.javabom.lotto.domain.info;

import com.javabom.lotto.domain.valid.GameNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @DisplayName("로또번호를 갖고 있으면 true, 갖고 있지 않으면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1,true", "9,false"})
    void has(String lottoNumber, boolean expected) {
        Lotto lotto = new Lotto(
                Arrays.asList(1, 2, 3, 4, 5, 6));
        GameNumber gameNumber = new GameNumber(lottoNumber);
        assertEquals(expected, lotto.has(gameNumber));
        assertEquals(expected, lotto.has(gameNumber));
    }
}