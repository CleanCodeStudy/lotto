package com.javabom.lotto.domain.compare;

import java.util.List;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResults that = (LottoResults) o;
        return Objects.equals(lottoResults, that.lottoResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResults);
    }
}
