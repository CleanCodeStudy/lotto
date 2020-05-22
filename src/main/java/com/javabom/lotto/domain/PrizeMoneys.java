package com.javabom.lotto.domain;

import java.util.List;

public class PrizeMoneys {
    private final List<Integer> prizeMoneys;

    public PrizeMoneys(List<Integer> prizeMoneys) {
        this.prizeMoneys = prizeMoneys;
    }

    public int getAmountOfPrize() {
        return prizeMoneys.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
