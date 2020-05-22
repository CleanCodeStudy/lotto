package com.javabom.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class WinningNumber {
    private final List<Integer> winningNumber;
    public final int bonusNumber;

    public WinningNumber(String winningNumber, String bonusNumber) {
        validWinningNumber(winningNumber);
        validBonusNumber(bonusNumber);
        this.winningNumber = splitWinningNumber(winningNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private List<Integer> splitWinningNumber(String winningNumber) {
        List<Integer> splitWinningNumber = Arrays.stream(winningNumber.split(","))
                .map(String::trim)
                .map(m -> {
                    validLottoNumber(m);
                    return Integer.parseInt(m);
                })
                .collect(Collectors.toList());
        validWinningNumberCount(splitWinningNumber);
        validDuplicatedNumber(splitWinningNumber);
        return splitWinningNumber;
    }

    private void validDuplicatedNumber(List<Integer> winningNumber) {
        Set<Integer> set = new HashSet<>(winningNumber);
        if (set.size() != winningNumber.size()) {
            throw new IllegalArgumentException("당첨번호에 중복된 번호가 존재합니다.");
        }
    }

    private void validWinningNumberCount(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException("입력된 당첨 번호 수가 6개가 아닙니다.");
        }
    }

    private void validWinningNumber(String winningNumber) {
        if (isEmptyWinningNumbers(winningNumber)) {
            throw new IllegalArgumentException("입력된 당첨 번호가 없습니다.");
        }
    }

    private void validNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("정수가 아닌 값이 입력 되었습니다.");
        }
    }

    private void validLottoNumber(String number) {
        if (Integer.parseInt(number) < 0 || Integer.parseInt(number) > 45) {
            throw new IllegalArgumentException("로또 번호가 아닙니다.");
        }
    }

    private boolean isEmptyWinningNumbers(String winningNumbers) {
        String[] splitNumbers = winningNumbers.split(",");
        return isEmptyNumbers(splitNumbers) || (splitNumbers.length == 0);
    }

    private boolean isEmptyNumbers(String[] numbers) {
        return Arrays.stream(numbers).map(String::trim).allMatch(s -> s.equals(""));
    }

    private void validBonusNumber(String bonusNumber) {
        validNumberFormat(bonusNumber);
        validLottoNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return new ArrayList<>(winningNumber);
    }
}
