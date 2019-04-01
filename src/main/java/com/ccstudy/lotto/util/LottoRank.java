package com.ccstudy.lotto.util;

import com.ccstudy.lotto.domain.LottoTicket;
import com.ccstudy.lotto.domain.WinningNumber;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    DEFAULT(0, 0);

    private int correctCount;
    private int receivedAmount;

    LottoRank(int correctCount, int receivedAmount) {
        this.correctCount = correctCount;
        this.receivedAmount = receivedAmount;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getReceivedAmount() {
        return receivedAmount;
    }

    public boolean isCorrectCount(int answerCount) {
        return this.correctCount == answerCount;
    }
}
