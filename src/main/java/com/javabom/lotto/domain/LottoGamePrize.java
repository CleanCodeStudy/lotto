package com.javabom.lotto.domain;

import java.util.Arrays;
import java.util.Map;

public enum LottoGamePrize {
    THREE_HIT(3, 5000), FOUR_HIT(4, 50000), FIVE_HIT(5, 1500000), SIX_HIT(6, 2000000000);

    private int countOfHit;
    private long price;

    LottoGamePrize(int countOfHit, int price) {
        this.countOfHit = countOfHit;
        this.price = price;
    }

    public static long calculateTotalPrice(Map<Integer, Long> lottoGameHits) {
        return Arrays.stream(LottoGamePrize.values())
                .filter(lottoGamePrize -> lottoGameHits.containsKey(lottoGamePrize.countOfHit))
                .map(lottoGamePrize -> lottoGameHits.get(lottoGamePrize.countOfHit) * lottoGamePrize.price)
                .reduce(0L, Long::sum);
    }
}
