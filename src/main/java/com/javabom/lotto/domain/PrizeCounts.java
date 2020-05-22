package com.javabom.lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrizeCounts {
    private final Map<Integer, Integer> prizeCounts = new HashMap<>();

    public PrizeCounts() {
        init();
    }

    private void init() {
        prizeCounts.put(3, 0);
        prizeCounts.put(4, 0);
        prizeCounts.put(5, 0);
        prizeCounts.put(6, 0);
        prizeCounts.put(50, 0);
    }

    public void compileStatisticsOfPrize(MatchedCounts matchedCounts) {
        prizeCounts.replaceAll((k, v) -> matchedCounts.getMatchedCount(k));
    }

    public List<Integer> getPrizeMoneys() {
        List<Integer> prizeMoneys = new ArrayList<>();
        for (int key : prizeCounts.keySet()) {
            PrizeType prizeType = PrizeType.valueOfPrize(key);
            prizeMoneys.add(prizeType.calculate(prizeCounts.get(key)));
        }
        return prizeMoneys;
    }

    public int getPrizeCount(int idx) {
        return prizeCounts.get(idx);
    }

    public boolean containKey(int idx) {
        return prizeCounts.containsKey(idx);
    }
}
