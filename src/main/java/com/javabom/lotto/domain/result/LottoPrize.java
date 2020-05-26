package com.javabom.lotto.domain.result;

import com.javabom.lotto.vo.Money;

import java.util.Arrays;
import java.util.List;

public enum LottoPrize {
    SIX_HIT(6, 2_000_000_000),
    FIVE_HIT(5, 1_500_000),
    FOUR_HIT(4, 50_000),
    THREE_HIT(3, 5_000),
    MISS(0, 0);

    private final int hitCount;
    private final long reward;

    LottoPrize(int hitCount, long reward) {
        this.hitCount = hitCount;
        this.reward = reward;
    }

    public static Money calculateTotalReword(List<LottoPrize> statistics) {
        Long totalMoney = statistics.stream()
                .map(LottoPrize::getReward)
                .reduce(0L, Long::sum);
        return new Money(totalMoney);
    }

    public static LottoPrize findByMathCount(int matchCount) {
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.hitCount == matchCount)
                .findAny()
                .orElse(MISS);
    }

    public long getReward() {
        return reward;
    }
}
