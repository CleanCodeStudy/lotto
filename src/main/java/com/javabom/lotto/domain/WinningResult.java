package com.javabom.lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningResult {
    private static final int COUNT_OF_LOTTO_NUMBER = 6;
    private final List<Integer> winningNumbers;

    public WinningResult(List<Integer> winningNumbers) {
        if (winningNumbers.size() != COUNT_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또숫자 갯수는 6개여야 합니다");
        }
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }
}
