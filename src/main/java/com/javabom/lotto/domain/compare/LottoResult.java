package com.javabom.lotto.domain.compare;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoResult {

    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 30_000_000),
    THIRD_PRIZE(5, 1_500_000),
    FOURTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(3, 5_000),
    LOSE(-1, 0);

    private final int matchCount;
    private final long price;

    LottoResult(int matchCount, long price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static LottoResult find(int matchCount, boolean isBonusMatched) {
        validateMatchCount(matchCount);
        if (matchCount == SECOND_PRIZE.matchCount && isBonusMatched) {
            return SECOND_PRIZE;
        }
        return valuesWithoutSecond().stream()
                .filter(result -> result.matchCount == matchCount)
                .findFirst()
                .orElse(LOSE);
    }

    private static void validateMatchCount(int matchCount) {
        if (matchCount < 0 || matchCount > 6) {
            throw new IllegalArgumentException("로또번호 매치 수는 0~6 사이입니다.");
        }
    }

    private static List<LottoResult> valuesWithoutSecond() {
        return Arrays.stream(values())
                .filter(result -> result != SECOND_PRIZE)
                .collect(Collectors.toList());
    }

    public long getPrice() {
        return price;
    }

    public int getMatchCount() {
        return matchCount;
    }

}
