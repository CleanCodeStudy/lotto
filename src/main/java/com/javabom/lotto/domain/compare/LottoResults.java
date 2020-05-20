package com.javabom.lotto.domain.compare;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResults {

    private final List<LottoResult> lottoResults;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public List<LottoResult> findResultsOf(LottoResult lottoResult) {
        return lottoResults.stream()
                .filter(result -> result == lottoResult)
                .collect(Collectors.toList());
    }

    public long getTotalPrizeMoney() {
        return lottoResults.stream()
                .mapToLong(LottoResult::getPrice)
                .sum();
    }
}
