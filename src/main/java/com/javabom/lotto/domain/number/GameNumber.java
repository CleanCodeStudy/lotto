package com.javabom.lotto.domain.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int gameNumber;

    private GameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public static GameNumber valueOf(int number) {
        checkRange(number);
        return GameNumberCache.cache.get(number);
    }

    public static GameNumber valueOf(String strNumber) {
        return GameNumber.valueOf(Integer.parseInt(strNumber));
    }

    private static void checkRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(String.format("입력값: %d, 당첨 번호는 1-45 숫자만 가능합니다.", number));
        }
    }

    public int value() {
        return this.gameNumber;
    }

    private static class GameNumberCache {
        static final List<GameNumber> cache;

        static {
            cache = new ArrayList<>();

            for (int idx = MIN_NUMBER - 1; idx <= MAX_NUMBER; idx++) {
                cache.add(new GameNumber(idx));
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameNumber)) return false;
        GameNumber that = (GameNumber) o;
        return gameNumber == that.gameNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameNumber);
    }
}
