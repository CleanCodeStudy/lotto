package com.javabom.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersTest {

    @DisplayName("당첨 결과를 제대로 찾는지 확인.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,13,10,12 | 25 | 0", "1,2,3,4,10,12 | 25 | 1", "1,2,3,4,5,12 | 25 | 2", "1,2,3,4,5,12 | 6 | 3"
    , "1,2,3,4,5,6 | 25 | 4", "1,2,14,13,10,12 | 25 | 5"}, delimiter = '|')
    public void findLottoRanksTest(String winningNumbers, String bonusNumber, int rankInfoIndex) {
        // given
        int gameMoney = 1000;
        List<Integer> numbers = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .boxed()
                .collect(Collectors.toList());
        LottoNumbers lottoNumbers = new LottoNumbers(gameMoney, new FixedLottoNumberGenerator(numbers));

        // when
        LottoRank[] winningRankInfos = LottoRank.values();
        List<Integer> winningNumberList = Arrays.stream(winningNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        List<LottoRank> lottoRanks = lottoNumbers.findLottoRanks(winningNumberList, Integer.parseInt(bonusNumber));

        // then
        assertEquals(winningRankInfos[rankInfoIndex], lottoRanks.get(0));
    }

    @Test
    public void getNumbersTest() {
        // given
        int gameMoney = 1000;
        List<Integer> numbers = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .boxed()
                .collect(Collectors.toList());
        LottoNumbers lottoNumbers = new LottoNumbers(gameMoney, new FixedLottoNumberGenerator(numbers));

        // when
        List<LottoNumber> lottoNumberList = lottoNumbers.getNumbers();

        // then
        assertEquals(numbers, lottoNumberList.get(0).getLottoNumber());
    }

}