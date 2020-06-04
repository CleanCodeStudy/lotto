package com.javabom.lotto.domain.result;

import com.javabom.lotto.domain.shop.LottoUser;
import com.javabom.lotto.domain.vo.Money;

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

    public int calculateProfitRatio(LottoUser lottoUser) {
        long revenue = calculateRevenue();
        Money money = lottoUser.getMoney();
        return (int) ((revenue / (double) money.getSpentMoney()) * 100);
    }

    public LottoResult getResults() {
        return results;
    }
}
