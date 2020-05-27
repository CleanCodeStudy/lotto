package com.javabom.lotto.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum PrizeType {
    FIRST(6) {
        @Override
        public long getPrize() {
            return 2_000_000_000;
        }
    },
    SECOND(50) {
        @Override
        public long getPrize() {
            return 30_000_000;
        }
    },
    THIRD(5) {
        @Override
        public long getPrize() {
            return 1_500_000;
        }
    },
    FOURTH(4) {
        @Override
        public long getPrize() {
            return 50_000;
        }
    },
    FIFTH(3) {
        @Override
        public long getPrize() {
            return 5_000;
        }
    };

    PrizeType(int prizeCount) {
        this.prizeCount = prizeCount;
    }

    public final int prizeCount;

    private static final Map<Integer, PrizeType> BY_PRIZE = new HashMap<>();

    static {
        for (PrizeType type : values()) {
            BY_PRIZE.put(type.prizeCount, type);
        }
    }

    public static PrizeType valueOfPrize(int prizeCount) {
        return BY_PRIZE.get(prizeCount);
    }

    public abstract long getPrize();
}
