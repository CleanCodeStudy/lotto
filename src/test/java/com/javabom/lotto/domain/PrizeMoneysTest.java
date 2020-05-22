package com.javabom.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PrizeMoneysTest {

    @DisplayName("각 로또 당첨금과 매치되는 당첨 횟수에 따라 가격이 잘 나오는지 확인한다.")
    @Test
    void getAmountOfPrize() {
        PrizeCounts prizeCounts = new PrizeCounts();

        MatchedCounts matchedCounts = new MatchedCounts(
                Arrays.asList(3, 3, 4, 4, 1, 2));
        prizeCounts.compileStatisticsOfPrize(matchedCounts);

        PrizeMoneys prizeMoneys = new PrizeMoneys(prizeCounts.getPrizeMoneys());
        assertEquals(110000, prizeMoneys.getAmountOfPrize());
    }
}