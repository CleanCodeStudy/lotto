package com.javabom.lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum PrizeType {
    FIRST(6) {
        @Override
        int calculate(int count) {
            return 2000000000 * count;
        }
    },
    SECOND(50) {
        @Override
        int calculate(int count) {
            return 30000000 * count;
        }
    },
    THIRD(5) {
        @Override
        int calculate(int count) {
            return 15000000 * count;
        }
    },
    FOURTH(4) {
        @Override
        int calculate(int count) {
            return 50000 * count;
        }
    },
    FIFTH(3) {
        @Override
        int calculate(int count) {
            return 5000 * count;
        }
    };

    public final int prizeCount;

    PrizeType(int prizeCount) {
        this.prizeCount = prizeCount;
    }

    private static final Map<Integer, PrizeType> BY_PRIZE = new HashMap<>();

    static {
        for (PrizeType type : values()) {
            BY_PRIZE.put(type.prizeCount, type);
        }
    }

    public static PrizeType valueOfPrize(int prizeCount) {
        return BY_PRIZE.get(prizeCount);
    }

    abstract int calculate(int count);
}
