package com.javabom.lotto.domain;

public class ProfitRatio {

    private int ratio;

    public ProfitRatio(int revenue, int gameMoney) {
        this.ratio = calculateRatio(revenue, gameMoney);
    }

    private int calculateRatio(int revenue, int gameMoney) {
        return (int) (revenue / (double) gameMoney) * 100;
    }

    public int getRatio() {
        return ratio;
    }
}
