package com.javabom.lotto.domain.result;

import com.javabom.lotto.vo.Money;

import java.util.Collections;
import java.util.List;

public class LottoResult {
    private static final int PERCENTAGE = 100;
    private final List<LottoPrize> lottoStatistics;

    public LottoResult(List<LottoPrize> lottoPrizes) {
        this.lottoStatistics = lottoPrizes;
    }

    public int getNumberOfHitTickets(final LottoPrize lottoPrize) {
        return Math.toIntExact(lottoStatistics.stream()
                .filter(lottoStatistic -> lottoStatistic.equals(lottoPrize))
                .count());
    }

    public double getRateOfProfit(final Money spentMoney) {
        Money totalProfit = LottoPrize.calculateTotalReword(lottoStatistics);
        return (double) totalProfit.getValue() / spentMoney.getValue() * PERCENTAGE;
    }

    public List<LottoPrize> getLottoStatistics() {
        return Collections.unmodifiableList(lottoStatistics);
    }
}
