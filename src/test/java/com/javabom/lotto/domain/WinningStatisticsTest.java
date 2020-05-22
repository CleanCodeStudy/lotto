package com.javabom.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningStatisticsTest {

    @Test
    @DisplayName("당첨결과에 맞게 각 당첨순위 개수를 반환하는지 확인.")
    public void getFindEachRankCountTest() {
        // given
        List<LottoRank> lottoRanks = new ArrayList<>();
        lottoRanks.add(LottoRank.FIFTH_PLACE);
        lottoRanks.add(LottoRank.FIFTH_PLACE);
        lottoRanks.add(LottoRank.FIRST_PLACE);
        WinningStatistics winningStatistics = new WinningStatistics(lottoRanks);

        // when
        HashMap<LottoRank, Integer> eachRankCount = winningStatistics.findEachRankCount();

        // then
        assertEquals(2, eachRankCount.get(LottoRank.FIFTH_PLACE));
        assertEquals(1, eachRankCount.get(LottoRank.FIRST_PLACE));
    }

    @Test
    @DisplayName("수익금을 계산한 후 수익률을 잘 반환하는지 확인.")
    public void getProfitRatio() {
        // given
        List<LottoRank> lottoRanks = new ArrayList<>();
        int gameMoney = 14000;
        lottoRanks.add(LottoRank.FIFTH_PLACE);
        WinningStatistics winningStatistics = new WinningStatistics(lottoRanks);

        // when
        ProfitRatio profitRatio = winningStatistics.getProfitRatio(gameMoney);
        int ratio = (int) (LottoRank.FIFTH_PLACE.getPrizeMoney() / (double) gameMoney) * 100;

        // then
        assertEquals(ratio, profitRatio.getRatio());
    }
}