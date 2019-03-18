package model;

import java.util.Map;

public class LottoResult {

    private static final int PERCENTAGE = 100;
    private Map<LottoRank, Integer> lottoResultAnalysis;
    private int beforeAmount;
    private float yield;

    public LottoResult(Map<LottoRank, Integer> lottoRankIntegerMap, int beforeAmount) {
        this.lottoResultAnalysis = lottoRankIntegerMap;
        this.beforeAmount = beforeAmount;
        this.yield = analyzeYield();
    }

    public Map<LottoRank, Integer> getLottoResultAnalysis() {
        return lottoResultAnalysis;
    }

    public float getYield() {
        return yield;
    }

    private float analyzeYield() {
        int nowAmount = 0;
        for (LottoRank lotto : lottoResultAnalysis.keySet()) {
            nowAmount += lotto.getPrice() * lottoResultAnalysis.get(lotto);
        }
        return yieldFormula(nowAmount, beforeAmount);
    }

    public static float yieldFormula(int nowAmount, int beforeAmount) {
        return nowAmount / (float) beforeAmount * PERCENTAGE;
    }

}
