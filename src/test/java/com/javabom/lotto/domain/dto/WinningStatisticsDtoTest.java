package com.javabom.lotto.domain.dto;

import com.javabom.lotto.domain.result.LottoRank;
import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.result.WinningStatistics;
import com.javabom.lotto.domain.shop.UserMoney;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WinningStatisticsDtoTest {

    @Test
    void getEachLottoRankCountTest() {
        List<LottoRank> ranks = new ArrayList<>();
        ranks.add(LottoRank.FIFTH_PLACE);
        WinningStatistics winningStatistics = new WinningStatistics(new LottoResult(ranks));
        UserMoney userMoney = new UserMoney(new UserMoneyDto("1000"));
        WinningStatisticsDto winningStatisticsDto = new WinningStatisticsDto(winningStatistics, userMoney);

        Map<LottoRank, Integer> eachLottoRankCount = winningStatisticsDto.getEachLottoRankCount();
        assertEquals(1, eachLottoRankCount.get(LottoRank.FIFTH_PLACE));
    }

    @Test
    void getProfitRatioTest() {
        List<LottoRank> ranks = new ArrayList<>();
        ranks.add(LottoRank.FIFTH_PLACE);
        WinningStatistics winningStatistics = new WinningStatistics(new LottoResult(ranks));
        UserMoney userMoney = new UserMoney(new UserMoneyDto("1000"));
        WinningStatisticsDto winningStatisticsDto = new WinningStatisticsDto(winningStatistics, userMoney);
        int profitRatio = winningStatisticsDto.getProfitRatio();

        assertEquals(500, profitRatio);

    }
}