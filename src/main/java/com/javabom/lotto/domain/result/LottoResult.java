package com.javabom.lotto.domain.result;

import java.util.Collections;
import java.util.List;

public class LottoResult {

    private final List<LottoRank> results;

    public LottoResult(List<LottoRank> results) {
        this.results = results;
    }

    public int getRankCount(LottoRank rank) {
        return (int) results.stream()
                .filter(lottoRank -> lottoRank.equals(rank))
                .count();
    }

    public List<LottoRank> getResults() {
        return Collections.unmodifiableList(results);
    }
}
