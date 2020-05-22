package com.javabom.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatchedCountsTest {

    @DisplayName("일치하는 갯수만큼 값을 찾아 반환하는지 확인한다.")
    @Test
    void getMatchedCount() {
        MatchedCounts matchedCounts = new MatchedCounts(
                Arrays.asList(3, 3, 5, 5, 3));
        assertEquals(3, matchedCounts.getMatchedCount(3));
        assertEquals(2, matchedCounts.getMatchedCount(5));
    }
}
