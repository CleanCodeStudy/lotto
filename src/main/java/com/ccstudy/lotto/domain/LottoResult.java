package com.ccstudy.lotto.domain;

import com.ccstudy.lotto.util.ReceivedType;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {
    private double yield;
    private List<Lotto> winningLottos;

    public LottoResult(List<Lotto> lottos,List<Integer> correctAnswer) {
        this.winningLottos = lottos.stream()
                .filter(lotto -> lotto.isWinNumbers(correctAnswer))
                .collect(Collectors.toList());
        this.yield = calculateYield(lottos.size() * LottoGame.LOTTO_PRICE);
    }

    public double getYield(){
        return yield;
    }

    public List<Lotto> getWinningLottos() {
        return winningLottos;
    }

    public double calculateYield(int purchasePrice){

        double yield = ((double) getReceivedAmount() / purchasePrice) * 100;

        return Math.round(yield * 100) / 100.0;
    }

    public int getReceivedAmount() {
        int receivedAmount = 0;

        for(Lotto lotto : winningLottos){
            receivedAmount += ReceivedType.receivedAmount(lotto.getAnswer());
        }

        return receivedAmount;
    }

    public int getWinningLottoCount(int correctCount){
        return (int)winningLottos.stream()
                .filter(lotto -> lotto.getAnswer() == correctCount)
                .count();
    }

}
