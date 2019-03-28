package com.ccstudy.lotto.domain;

import java.util.List;

public class WinningNumber {
    private List<Integer> correctNumbers;
    private int bonusNumber;

    public WinningNumber(List<Integer> correctNumbers, int bonusNumber) {
        this.correctNumbers = correctNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isCorrectBonus(Lotto lotto) {
        return (lotto.getNumbers().contains(bonusNumber));
    }

    public int getAnswerCount(Lotto lotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(correctNumbers::contains)
                .count();
    }
}
