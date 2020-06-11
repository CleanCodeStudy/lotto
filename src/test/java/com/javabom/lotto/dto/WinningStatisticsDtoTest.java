package com.javabom.lotto.dto;

import com.javabom.lotto.domain.result.LottoRank;
import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.result.WinningStatistics;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningStatisticsDtoTest {

    @Test
    void getEachLottoRankCountTest() {
        List<LottoRank> ranks = new ArrayList<>();
        ranks.add(LottoRank.FIFTH_PLACE);
        WinningStatistics winningStatistics = new WinningStatistics(new LottoResult(ranks));
        WinningStatisticsDto winningStatisticsDto = new WinningStatisticsDto(winningStatistics);

        Map<LottoRank, Integer> eachLottoRankCount = winningStatisticsDto.getEachLottoRankCount();
        assertEquals(1, eachLottoRankCount.get(LottoRank.FIFTH_PLACE));
    }

    @Test
    void getProfitRatioTest() {
        List<LottoRank> ranks = new ArrayList<>();
        ranks.add(LottoRank.FIFTH_PLACE);

        WinningStatistics winningStatistics = new WinningStatistics(new LottoResult(ranks));
        WinningStatisticsDto winningStatisticsDto = new WinningStatisticsDto(winningStatistics);
        int profitRatio = winningStatisticsDto.getProfitRatio();

        assertEquals(500, profitRatio);

    }
}