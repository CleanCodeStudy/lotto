package com.javabom.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    @DisplayName("당첨 번호와 같은 로또 번호의 개수를 제대로 반환하는지 테스트.")
    void getSameCountByWinnerNumberTest() {
        List<Integer> lottoNumber = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .boxed()
                .collect(Collectors.toList());

        List<Integer> winningNumber = Arrays.stream(new int[]{10, 11, 22, 4, 5, 6})
                .boxed()
                .collect(Collectors.toList());
        LottoNumber lottoNumbers = new LottoNumber(new FixedLottoNumberGenerator(lottoNumber));

        assertEquals(3, lottoNumbers.getSameCountByWinnerNumber(winningNumber));
    }

    @Test
    @DisplayName("보너스 번호가 존재 유무를 확인하는 테스트.")
    void hasBonusNumberTest() {
        List<Integer> lottoNumber = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .boxed()
                .collect(Collectors.toList());
        LottoNumber lottoNumbers = new LottoNumber(new FixedLottoNumberGenerator(lottoNumber));
        assertTrue(lottoNumbers.hasBonusNumber(1));
        assertFalse(lottoNumbers.hasBonusNumber(25));
    }
}