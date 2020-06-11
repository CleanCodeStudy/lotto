package com.javabom.lotto.dto;

import com.javabom.lotto.domain.result.LottoRank;
import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.result.WinningStatistics;

import java.util.LinkedHashMap;
import java.util.Map;


public class WinningStatisticsDto {

    private final LottoResult results;

    private final int profitRatio;

    public WinningStatisticsDto(WinningStatistics winningStatistics) {
        this.results = winningStatistics.getResults();
        this.profitRatio = winningStatistics.calculateProfitRatio();
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
