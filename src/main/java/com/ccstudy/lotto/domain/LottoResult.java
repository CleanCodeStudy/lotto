package com.ccstudy.lotto.domain;

import com.ccstudy.lotto.util.ReceivedType;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {
    public static final int MIN_WIN_COUNT = 3;
    private double yield;
    private List<Lotto> winningLottos;
    private List<Integer> correctNumber;

    public LottoResult(List<Lotto> lottos, List<Integer> correctNumber) {
        this.correctNumber = correctNumber;

        this.winningLottos = lottos.stream()
                .filter(lotto -> lotto.getAnswer(correctNumber) >= MIN_WIN_COUNT)
                .collect(Collectors.toList());

        this.yield = calculateYield(lottos.size());
    }

    public double getYield(){
        return yield;
    }

    public List<Lotto> getWinningLottos() {
        return winningLottos;
    }

    public double calculateYield(int amountOfLottos) {
        int purchasePrice = amountOfLottos * LottoGame.LOTTO_PRICE;

        double yield = ((double) getReceivedAmount() / purchasePrice) * 100;

        return Math.round(yield * 100) / 100.0;
    }

    public int getReceivedAmount() {
        int receivedAmount = 0;

        for(Lotto lotto : winningLottos){
            receivedAmount += ReceivedType.receivedAmount(lotto.getAnswer(correctNumber));
        }

        return receivedAmount;
    }

    public int getWinningLottoCount(int correctCount){
        return (int)winningLottos.stream()
                .filter(lotto -> lotto.getAnswer(correctNumber) == correctCount)
                .count();
    }

}
