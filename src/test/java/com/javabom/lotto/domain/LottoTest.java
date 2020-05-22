package com.javabom.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @DisplayName("로또번호를 갖고 있으면 true, 갖고 있지 않으면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1,true", "9,false"})
    void has(int lottoNumber, boolean expected) {
        Lotto lotto = new Lotto(
                Arrays.asList(1, 2, 3, 4, 5, 6));
        assertEquals(expected, lotto.has(lottoNumber));
        assertEquals(expected, lotto.has(lottoNumber));
    }

    @DisplayName("생성한 로또번호와 값이잘 들어갔는지 확인한다.")
    @Test
    void get() {
        Lotto lotto = new Lotto(
                Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> actual = lotto.getLotto();
        assertEquals(1, actual.get(0));
        assertEquals(2, actual.get(1));
        assertEquals(3, actual.get(2));
        assertEquals(4, actual.get(3));
        assertEquals(5, actual.get(4));
        assertEquals(6, actual.get(5));
    }
}