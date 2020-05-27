package com.javabom.lotto.domain.result;

import com.javabom.lotto.domain.enums.PrizeType;

public class LottoResult {

    private final int FAIL = 0;

    private int lottoResult;

    public LottoResult(int lottoResult) {
        this.lottoResult = lottoResult;
    }

    public long getPrize() {
        PrizeType prizeType = PrizeType.valueOfPrize(lottoResult);
        if (prizeType != null) {
            return prizeType.getPrize();
        }
        return FAIL;
    }

    public boolean isEquals(int matchedCount) {
        return this.lottoResult == matchedCount;
    }
}
