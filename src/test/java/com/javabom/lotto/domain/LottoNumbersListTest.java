package com.javabom.lotto.domain;

import com.javabom.lotto.domain.lottery.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersListTest {

    @DisplayName("당첨 결과를 제대로 찾는지 확인.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,13,10,12 | 25 | 0", "1,2,3,4,10,12 | 25 | 1", "1,2,3,4,5,12 | 25 | 2", "1,2,3,4,5,12 | 6 | 3"
            , "1,2,3,4,5,6 | 25 | 4", "1,2,14,13,10,12 | 25 | 5"}, delimiter = '|')
    public void findLottoRanksTest(String winningNumbers, String bonusNumber, int rankInfoIndex) {
        // given
        int gameMoney = 1000;
        List<LottoNumber> numbers = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumbersList lottoNumbersList = new LottoNumbersList(gameMoney, new FixedLottoNumberGenerator(numbers));

        // when
        LottoRank[] winningRankInfos = LottoRank.values();
        List<LottoRank> lottoRanks = lottoNumbersList.findLottoRanks(new WinningNumbers(winningNumbers), new BonusNumber(bonusNumber));

        // then
        assertEquals(winningRankInfos[rankInfoIndex], lottoRanks.get(0));
    }

    @Test
    public void getNumbersTest() {
        // given
        int gameMoney = 1000;
        List<LottoNumber> numbers = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        LottoNumbersList lottoNumbersList = new LottoNumbersList(gameMoney, new FixedLottoNumberGenerator(numbers));

        // when
        List<LottoNumbers> lottoNumberList = lottoNumbersList.getNumbers();

        // then
        assertEquals(numbers, lottoNumberList.get(0).getNumbers());
    }

}