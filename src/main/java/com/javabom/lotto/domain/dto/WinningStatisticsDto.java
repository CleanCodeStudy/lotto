package com.javabom.lotto.domain.dto;

import com.javabom.lotto.domain.result.WinningStatistics;
import com.javabom.lotto.domain.result.LottoRank;
import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.shop.LottoUser;

import java.util.*;


public class WinningStatisticsDto {

    private final LottoResult results;

    private final int profitRatio;

    public WinningStatisticsDto(WinningStatistics winningStatistics, LottoUser lottoUser) {
        this.results = winningStatistics.getResults();
        this.profitRatio = winningStatistics.calculateProfitRatio(lottoUser);
    }

    public Map<LottoRank, Integer> getEachLottoRankCount() {
        Map<LottoRank, Integer> lottoRankMap = new LinkedHashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoRankMap.put(lottoRank, results.getRankCount(lottoRank));
        }
        lottoRankMap.remove(LottoRank.FAIL);
        return lottoRankMap;
    }

    public int getProfitRatio() {
        return profitRatio;
    }
}
