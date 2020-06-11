package com.javabom.lotto.domain.result;

import java.util.Arrays;

public enum LottoResult {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    FAIL(0, 0);

    LottoResult(int matchedCount, int prize) {
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public final int matchedCount;
    public final int prize;

    public static LottoResult findLottoResult(int matchedCount, boolean bonusStatus) {
        if (matchedCount == 5) {
            return findBonus(bonusStatus);
        }
        return valueOf(matchedCount);
    }

    private static LottoResult findBonus(boolean bonusStatus) {
        if (bonusStatus) {
            return SECOND;
        }
        return THIRD;
    }

    public static LottoResult valueOf(int matchedCount){
        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.getMatchedCount() == matchedCount)
                .filter(lottoResult -> !lottoResult.equals(SECOND))
                .findFirst()
                .orElse(FAIL);
    }

    private int getMatchedCount(){
        return this.matchedCount;
    }

    public int getPrize() {
        return this.prize;
    }
}
