package com.javabom.lotto.domain.result;

import java.util.List;

public class LottoResultBundle {
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

    public long getRateOfProfit(int amount) {
        long profit = calculatePrize() - amount;
        if (profit < 0) {
            return 0;
        }
        return (profit / amount) * PERCENT;
    }

    public int getCountOfPrize(LottoResult lottoResult) {
        return (int) lottoResultBundle.stream()
                .filter(result -> result.equals(lottoResult))
                .count();
    }

    public LottoResult valueOf(int idx){
        return lottoResultBundle.get(idx);
    }
}
