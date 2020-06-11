package com.javabom.lotto.domain.result;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @Test
    void getRankCountTest() {
        List<LottoRank> ranks = new ArrayList<>();
        ranks.add(LottoRank.FIFTH_PLACE);
        ranks.add(LottoRank.FIFTH_PLACE);
        LottoResult result = new LottoResult(ranks);

        assertEquals(2, result.getRankCount(LottoRank.FIFTH_PLACE));
    }

    @Test
    void getResultsTest() {
        List<LottoRank> ranks = new ArrayList<>();
        ranks.add(LottoRank.FIFTH_PLACE);
        ranks.add(LottoRank.FIFTH_PLACE);
        LottoResult result = new LottoResult(ranks);

        assertEquals(2, result.getResults().size());
    }
}