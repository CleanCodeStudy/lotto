package com.javabom.lotto.domain;

import java.util.Map;

public class LottoGameResult {
    private final Map<Integer, Long> hitCounts;

    public LottoGameResult(Map<Integer, Long> hitCounts) {
        this.hitCounts = hitCounts;
    }

    public Long findByHitCount(final int hitCount) {
        return hitCounts.get(hitCount);
    }

    public long calculateTotalReword() {
        return LottoGamePrize.getTotalPrice(hitCounts);
    }
}
