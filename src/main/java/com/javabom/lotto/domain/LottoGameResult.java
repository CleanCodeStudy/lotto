package com.javabom.lotto.domain;

import java.util.Map;
import java.util.Objects;

public class LottoGameResult {
    private final Map<Integer, Long> hitCounts;

    public LottoGameResult(Map<Integer, Long> hitCounts) {
        this.hitCounts = hitCounts;
    }

    public Long findByHitCount(final int hitCount) {
        Long frequency = this.hitCounts.get(hitCount);
        return Objects.isNull(frequency) ? 0 : frequency;
    }

    public long calculateTotalReword() {
        return LottoGamePrize.calculateTotalPrice(hitCounts);
    }

    public double calculateRateOfProfit(final int totalPrice) {
        long totalReword = calculateTotalReword();
        return (double) totalReword / totalPrice;
    }

}
