package com.javabom.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PrizeNumbers {
    private List<Integer> prizeNumbers;

    public PrizeNumbers(List<String> strPrizeNumbers) {
        checkCount(strPrizeNumbers.size());
        List<Integer> prizeNumbers = new ArrayList<>();
        for (String strPrizeNumber : strPrizeNumbers) {
            int prizeNumber = parseInt(strPrizeNumber);
            checkRange(parseInt(strPrizeNumber));
            prizeNumbers.add(prizeNumber);
        }
        this.prizeNumbers = prizeNumbers;
    }

    private void checkCount(int numberCount) {
        if (numberCount < 6) {
            throw new IllegalArgumentException("당첨 번호는 총 6개여야 합니다.");
        }
    }

    private int parseInt(String strPrizeNumber) {
        try {
            return Integer.parseInt(strPrizeNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("당첨 번호는 숫자만 들어올 수 있습니다.");
        }
    }

    private void checkRange(int prizeNumber) {
        if (isNotRange(prizeNumber)) {
            throw new IllegalArgumentException("당첨번호는 1부터 45까지만 있을 수 있습니다.");
        }
    }

    private boolean isNotRange(int prizeNumber) {
        return prizeNumber < 1 || prizeNumber > 45;
    }

    public int getMatchedCount(Lotto lotto) {
        return (int) prizeNumbers.stream()
                .filter(lotto::has)
                .count();
    }

    public boolean has(int number) {
        if (prizeNumbers.contains(number)) {
            return true;
        }
        return false;
    }
}
