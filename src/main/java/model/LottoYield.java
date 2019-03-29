package model;

import java.util.List;
import java.util.Map;

public class LottoYield {

    private static final int PERCENTAGE = 100;

    private Map<LottoRank, List<LottoTicket>> rankLottoGroup;

    private int beforeAmount;
    private float yield;

    public LottoYield(LottoGame lottoGame, int beforeAmount) {
        this.rankLottoGroup = lottoGame.getRankLottoGroup();
        this.beforeAmount = beforeAmount;
        this.yield = analyzeYield();
    }

    public Map<LottoRank, List<LottoTicket>> getRankLottoGroup() {
        return rankLottoGroup;
    }

    public float getYield() {
        return yield;
    }

    private float yieldFormula(int nowPrice, int beforePrice) {
        return nowPrice / (float) beforePrice * PERCENTAGE;
    }

    public float analyzeYield() {
        int nowAmount = 0;

        for(LottoRank lottoRank: rankLottoGroup.keySet()){
            nowAmount += lottoRank.getPrice() * rankLottoGroup.get(lottoRank).size();
        }

        return yieldFormula(nowAmount, beforeAmount);
    }

}
