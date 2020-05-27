package com.javabom.lotto.domain.result;

import com.javabom.lotto.domain.vo.Money;

import java.util.Collections;
import java.util.List;

public class LottoResultBundle {
    private final int FAIL = 0;
    private final int PERCENT = 100;
    private final List<LottoResult> lottoResultBundle;

    public LottoResultBundle(List<LottoResult> lottoResultBundle) {
        this.lottoResultBundle = lottoResultBundle;
    }

    public long calculatePrize() {
        long prize = 0;
        for (LottoResult lottoResult : lottoResultBundle) {
            prize += lottoResult.getPrize();
        }
        return prize;
    }

    public long getRateOfProfit(Money money) {
        int amount = money.get();
        long profit = calculatePrize() - amount;
        if (profit < FAIL) {
            return FAIL;
        }
        return (profit / amount) * PERCENT;
    }

    public int getCountOfPrize(int matchedCount) {
        return (int) lottoResultBundle.stream()
                .filter(lottoResult -> lottoResult.isEquals(matchedCount))
                .count();
    }

    public List<LottoResult> get() {
        return Collections.unmodifiableList(lottoResultBundle);
    }
}
