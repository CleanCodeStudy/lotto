package com.javabom.lotto.domain.ticket;

import java.util.Arrays;

public enum LottoRank {
    FIFTH_PLACE(5000, 3, "3개 일치 (5000원)"),
    FOURTH_PLACE(50000, 4, "4개 일치 (500000원)"),
    THIRD_PLACE(1500000, 5, "5개 일치 (1500000원)"),
    SECOND_PLACE(30000000, 5, "5개 일치, 보너스 볼 일치 (30000000원)"),
    FIRST_PLACE(2000000000, 6, "6개 일치 (20000000000원)"),
    FAIL(0, 0, "꽝");

    private int prizeMoney;
    private int sameCount;
    private String rankInfo;

    LottoRank(int prizeMoney, int sameCount, String rankInfo) {
        this.prizeMoney = prizeMoney;
        this.sameCount = sameCount;
        this.rankInfo = rankInfo;
    }

    public static LottoRank findBySameCount(int sameCount) {
        return Arrays.stream(LottoRank.values())
                .filter(rankInfo -> rankInfo.sameCount == sameCount)
                .findAny()
                .orElse(FAIL);
    }

    public static LottoRank findLottoRank(int sameCount, boolean hasBonusNumber) {
        if (sameCount == 5 && hasBonusNumber) {
            return LottoRank.SECOND_PLACE;
        }

        return findBySameCount(sameCount);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getSameCount() {
        return sameCount;
    }

    public String getRankInfo() {
        return rankInfo;
    }
}
