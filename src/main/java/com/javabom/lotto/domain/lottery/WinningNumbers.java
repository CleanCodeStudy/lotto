package com.javabom.lotto.domain.lottery;

import com.javabom.lotto.domain.LottoNumberValidator;

import java.util.*;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<LottoNumber> numbers;

    public WinningNumbers(String numbers) {
        validWinningNumber(numbers);
        this.numbers = splitWinningNumber(numbers);
    }

    private List<LottoNumber> splitWinningNumber(String winningNumber) {
        validSplitNumbers(winningNumber);
        return Arrays.stream(winningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validSplitNumbers(String winningNumber) {
        checkEachNumber(winningNumber);
        List<Integer> numbers = Arrays.stream(winningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validWinningNumberCount(numbers);
        validDuplicatedNumber(numbers);
    }

    private void checkEachNumber(String winningNumber) {
        for (String number : winningNumber.split(",")) {
            LottoNumberValidator.validLottoNumber(number.trim());
        }
    }

    private void validDuplicatedNumber(List<Integer> winningNumber) {
        Set<Integer> set = new HashSet<>(winningNumber);
        if (set.size() != winningNumber.size()) {
            throw new IllegalArgumentException("당첨번호에 중복된 번호가 존재합니다.");
        }
    }

    private void validWinningNumberCount(List<Integer> winningNumber) {
        if (winningNumber.size() != LottoNumbers.MAX_LOTTO_COUNTS) {
            throw new IllegalArgumentException("입력된 당첨 번호 수가 6개가 아닙니다.");
        }
    }

    private void validWinningNumber(String winningNumber) {
        if (isEmptyWinningNumbers(winningNumber)) {
            throw new IllegalArgumentException("입력된 당첨 번호가 없습니다.");
        }
    }

    private boolean isEmptyWinningNumbers(String winningNumbers) {
        String[] splitNumbers = winningNumbers.split(",");
        return isEmptyNumbers(splitNumbers) || (splitNumbers.length == 0);
    }

    private boolean isEmptyNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .map(String::trim)
                .allMatch(String::isEmpty);
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
