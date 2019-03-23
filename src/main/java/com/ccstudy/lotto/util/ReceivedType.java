package com.ccstudy.lotto.util;

import java.util.Arrays;

public enum ReceivedType {
    THREE(3,5000),
    FOUR(4,50000),
    FIVE(5,1500000),
    SIX(6, 2000000000),
    DEFAULT(0, 0);

    private int correctCount;
    private int receivedAmount;

    ReceivedType(int correctCount, int receivedAmount) {
        this.correctCount = correctCount;
        this.receivedAmount = receivedAmount;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getReceivedAmount() {
        return receivedAmount;
    }

    public static int receivedAmount(int answerCount){
        return Arrays.stream(ReceivedType.values())
                .filter(receivedType -> receivedType.isCorrectCount(answerCount))
                .findAny()
                .orElse(DEFAULT)
                .receivedAmount;
    }

    public boolean isCorrectCount(int answerCount){
        return this.correctCount == answerCount;
    }
}
