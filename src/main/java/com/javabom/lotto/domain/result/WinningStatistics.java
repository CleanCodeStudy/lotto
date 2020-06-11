package com.javabom.lotto.domain.result;

import com.javabom.lotto.domain.shop.LottoShop;

public class WinningStatistics {

    private final LottoResult results;

    public WinningStatistics(LottoResult results) {
        this.results = results;
    }

    private long calculateRevenue() {
        long revenue = 0;
        for (LottoRank result : results.getResults()) {
            revenue += result.getPrizeMoney();
        }
        return revenue;
    }

    public int calculateProfitRatio() {
        long revenue = calculateRevenue();
        return (int) ((revenue / (double) calculateCostMoney()) * 100);
    }

    private long calculateCostMoney() {
        return results.size() * LottoShop.TICKET_PRICE.getValue();
    }

    public LottoResult getResults() {
        return results;
    }
}
