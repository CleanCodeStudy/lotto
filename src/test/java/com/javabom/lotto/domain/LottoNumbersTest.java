package com.javabom.lotto.domain;

import com.javabom.lotto.domain.lottery.LottoNumber;
import com.javabom.lotto.domain.lottery.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersTest {

    @Test
    @DisplayName("당첨 번호와 같은 로또 번호의 개수를 제대로 반환하는지 테스트.")
    void getSameCountByWinnerNumberTest() {
        List<LottoNumber> lottoNumber = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        List<LottoNumber> winningNumber = Arrays.stream(new int[]{10, 11, 22, 4, 5, 6})
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        FixedLottoNumberGenerator numberGenerator = new FixedLottoNumberGenerator(lottoNumber);
        LottoNumbers lottoNumbers = new LottoNumbers(numberGenerator.getNumbers());

        assertEquals(3, lottoNumbers.getSameCountByWinnerNumber(winningNumber));
    }

    @Test
    @DisplayName("보너스 번호가 존재 유무를 확인하는 테스트.")
    void hasBonusNumberTest() {
        List<LottoNumber> lottoNumber = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        FixedLottoNumberGenerator numberGenerator = new FixedLottoNumberGenerator(lottoNumber);
        LottoNumbers lottoNumbers = new LottoNumbers(numberGenerator.getNumbers());
        assertTrue(lottoNumbers.hasBonusNumber(new LottoNumber(1)));
        assertFalse(lottoNumbers.hasBonusNumber(new LottoNumber(25)));
    }
}