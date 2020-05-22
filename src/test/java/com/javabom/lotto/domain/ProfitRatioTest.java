package com.javabom.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfitRatioTest {

    @Test
    @DisplayName("수익률을 잘 계산하는지 확인.")
    public void getRatioTest() {
        ProfitRatio profitRatio = new ProfitRatio(3000, 12000);

        assertEquals(40, profitRatio.getRatio());
    }

}