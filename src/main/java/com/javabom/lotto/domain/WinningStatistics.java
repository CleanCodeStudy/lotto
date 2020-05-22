package com.javabom.lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class WinningStatistics {

    private final List<LottoRank> results;

    public WinningStatistics(List<LottoRank> results) {
        this.results = results;
    }

    private int calculateRevenue() {
        int revenue = 0;
        for (LottoRank result : results) {
            revenue += result.getPrizeMoney();
        }
        return revenue;
    }

    private int getRankCount(LottoRank lottoRank) {
        return (int) results.stream()
                .filter(m -> m.equals(lottoRank))
                .count();
    }

    public HashMap<LottoRank, Integer> findEachRankCount() {
        HashMap<LottoRank, Integer> rankCountMap = new LinkedHashMap<>();
        List<LottoRank> lottoRanks = Arrays.stream(LottoRank.values())
                .filter(m -> !m.equals(LottoRank.FAIL))
                .collect(Collectors.toList());

        for (LottoRank lottoRank : lottoRanks) {
            rankCountMap.put(lottoRank, getRankCount(lottoRank));
        }
        return rankCountMap;
    }

    public ProfitRatio getProfitRatio(int gameMoney) {
        int revenue = calculateRevenue();
        return new ProfitRatio(revenue, gameMoney);
    }
}
