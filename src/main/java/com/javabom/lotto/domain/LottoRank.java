package com.javabom.lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIFTH_PLACE(5000, 3),
    FOURTH_PLACE(50000, 4),
    THIRD_PLACE(1500000, 5),
    SECOND_PLACE(30000000, 5),
    FIRST_PLACE(2000000000, 6 ),
    FAIL(0, -1);

    private int prizeMoney;
    private int sameCount;

    LottoRank(int prizeMoney, int sameCount) {
        this.prizeMoney = prizeMoney;
        this.sameCount = sameCount;
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
}
