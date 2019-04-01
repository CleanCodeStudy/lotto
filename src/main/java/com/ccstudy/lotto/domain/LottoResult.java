package com.ccstudy.lotto.domain;

import com.ccstudy.lotto.util.LottoRank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {
    public static final int MIN_WIN_COUNT = 3;
    private double yield;
    private List<LottoRank> winningRanks;
    private WinningNumber winningNumber;

    public LottoResult(List<LottoTicket> lottoTickets, WinningNumber winningNumber) {
        this.winningNumber = winningNumber;

        this.winningRanks = lottoTickets.stream()
                .map(lottoTicket -> getMatchingRank(lottoTicket))
                .collect(Collectors.toList());

        this.yield = calculateYield(lottoTickets.size());
    }

    public List<LottoRank> getWinningRanks() {
        return winningRanks;
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }

    public double getYield(){
        return yield;
    }

    public double calculateYield(int amountOfLottos) {
        int purchasePrice = amountOfLottos * LottoGame.LOTTO_PRICE;

        double yield = ((double) getReceivedAmount() / purchasePrice) * 100;

        return Math.round(yield * 100) / 100.0;
    }

    public int getReceivedAmount() {
        int receivedAmount = 0;

        for (LottoRank rank : winningRanks) {
            receivedAmount += rank.getReceivedAmount();
        }

        return receivedAmount;
    }

    public int getWinningLottoCount(LottoRank lottoRank) {
        return (int) winningRanks.stream()
                .filter(receivedType1 -> receivedType1 == lottoRank)
                .count();
    }

    public LottoRank getMatchingRank(LottoTicket lottoTicket) {
        LottoRank matchingRank = LottoRank.DEFAULT;

        for (LottoRank rank : LottoRank.values()) {
            if (rank.isCorrectCount(winningNumber.getAnswerCount(lottoTicket))) {
                matchingRank = rank;
            }
        }

        if (matchingRank == LottoRank.THIRD && winningNumber.isCorrectBonus(lottoTicket)) {
            matchingRank = LottoRank.SECOND;
        }
        return matchingRank;
    }

}
