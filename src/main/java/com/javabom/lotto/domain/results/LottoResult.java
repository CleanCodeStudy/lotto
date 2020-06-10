package com.javabom.lotto.domain.results;

import java.util.Arrays;

public enum LottoResult {

    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 30_000_000),
    THIRD_PRIZE(5, 1_500_000),
    FOURTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(3, 5_000),
    LOSE(-1, 0);

    private final int matchCount;
    private final long prize;

    LottoResult(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoResult find(final int matchCount, final boolean isBonusMatched) {
        validateMatchCount(matchCount);
        if (matchCount == SECOND_PRIZE.matchCount) {
            return findByBonus(isBonusMatched);
        }
        return Arrays.stream(values())
                .filter(result -> result.matchCount == matchCount)
                .findFirst()
                .orElse(LOSE);
    }

    private static void validateMatchCount(final int matchCount) {
        if (matchCount < 0 || matchCount > 6) {
            throw new IllegalArgumentException("로또번호 매치 수는 0~6 이외일 수 없습니다.");
        }
    }

    private static LottoResult findByBonus(final boolean isBonusMatched) {
        if (isBonusMatched) {
            return SECOND_PRIZE;
        }
        return THIRD_PRIZE;
    }

    public long getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

}
