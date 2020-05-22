package com.javabom.lotto.domain;

import java.util.List;

public class MatchedCounts {
    private final List<Integer> matchedCounts;

    public MatchedCounts(List<Integer> matchedCounts) {
        this.matchedCounts = matchedCounts;
    }

    public int getMatchedCount(int key){
        return (int) matchedCounts.stream()
                .filter(matchedCount -> matchedCount.equals(key))
                .count();
    }
}
