package com.ccstudy.lotto.util;

import com.ccstudy.lotto.domain.Lotto;
import com.ccstudy.lotto.domain.WinningNumber;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    DEFAULT(0, false, 0);

    private int correctCount;
    private Boolean correctBonus;
    private int receivedAmount;

    LottoRank(int correctCount, Boolean correctBonus, int receivedAmount) {
        this.correctCount = correctCount;
        this.correctBonus = correctBonus;
        this.receivedAmount = receivedAmount;
    }

    public static LottoRank getRank(Lotto lotto, WinningNumber winningNumber) {

        int answerCount = winningNumber.getAnswerCount(lotto);
        boolean correctBonus = winningNumber.isCorrectBonus(lotto);

        return Arrays.stream(LottoRank.values())
                .filter(receivedType -> receivedType.isCorrectCount(answerCount) &&
                        Boolean.logicalOr(!receivedType.correctBonus, correctBonus))
                .findAny()
                .orElse(DEFAULT);
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getReceivedAmount() {
        return receivedAmount;
    }

    public boolean isCorrectBonus() {
        return correctBonus;
    }

    public boolean isCorrectCount(int answerCount) {
        return this.correctCount == answerCount;
    }
}
