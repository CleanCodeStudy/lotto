package com.javabom.lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinningResult {
    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final int COUNT_OF_LOTTO_NUMBER = 6;

    private final List<Integer> winningNumbers;

    public WinningResult(final String winningNumbers) {
        List<Integer> splitedWinningNumbers = Arrays.stream(winningNumbers.split(WINNING_NUMBER_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validate(splitedWinningNumbers);
        this.winningNumbers = splitedWinningNumbers;
    }

    public void validate(final List<Integer> winningNumbers) {
        if (winningNumbers.size() != COUNT_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또숫자 갯수는 6개여야 합니다");
        }
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }
}
