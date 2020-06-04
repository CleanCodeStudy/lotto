package com.javabom.lotto.domain.dto;

import com.javabom.lotto.domain.result.LottoRank;
import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.result.WinningStatistics;
import com.javabom.lotto.domain.shop.LottoNumberShuffler;
import com.javabom.lotto.domain.shop.LottoShop;
import com.javabom.lotto.domain.shop.LottoUser;
import com.javabom.lotto.domain.vo.Money;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WinningStatisticsDtoTest {

    @Test
    void getEachLottoRankCountTest() {
        List<LottoRank> ranks = new ArrayList<>();
        ranks.add(LottoRank.FIFTH_PLACE);
        WinningStatistics winningStatistics = new WinningStatistics(new LottoResult(ranks));
        LottoUser lottoUser = new LottoUser(new Money(new MoneyDto("5000")), new ManualLottoCountDto("3"));
        WinningStatisticsDto winningStatisticsDto = new WinningStatisticsDto(winningStatistics, lottoUser);

        Map<LottoRank, Integer> eachLottoRankCount = winningStatisticsDto.getEachLottoRankCount();
        assertEquals(1, eachLottoRankCount.get(LottoRank.FIFTH_PLACE));
    }

    @Test
    void getProfitRatioTest() {
        LottoUser lottoUser = new LottoUser(new Money(new MoneyDto("1000")), new ManualLottoCountDto("0"));
        lottoUser.getMoney().spendMoney(1000);

        List<LottoRank> ranks = new ArrayList<>();
        ranks.add(LottoRank.FIFTH_PLACE);

        WinningStatistics winningStatistics = new WinningStatistics(new LottoResult(ranks));
        WinningStatisticsDto winningStatisticsDto = new WinningStatisticsDto(winningStatistics, lottoUser);
        int profitRatio = winningStatisticsDto.getProfitRatio();

        assertEquals(500, profitRatio);

    }
}