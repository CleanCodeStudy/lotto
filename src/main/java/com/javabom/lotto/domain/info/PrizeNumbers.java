package com.javabom.lotto.domain.info;

import com.javabom.lotto.domain.valid.GameNumber;

import java.util.List;
import java.util.stream.Collectors;

public class PrizeNumbers {

    private final int PRIZE_COUNT = 6;

    private final List<GameNumber> prizeNumbers;

    public PrizeNumbers(List<String> strPrizeNumbers) {
        checkCount(strPrizeNumbers.size());
        this.prizeNumbers = collectPrizeNumbers(strPrizeNumbers);
        checkDuplicate();
    }

    private void checkCount(int numberCount) {
        if (numberCount != PRIZE_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 총 6개여야 합니다.");
        }
    }

    private List<GameNumber> collectPrizeNumbers(List<String> strPrizeNumbers) {
        return strPrizeNumbers.stream()
                .distinct()
                .map(GameNumber::new)
                .collect(Collectors.toList());
    }

    private void checkDuplicate() {
        if (prizeNumbers.size() != PRIZE_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 모두 달라야 합니다.");
        }
    }

    public int getMatchedCount(Lotto lotto) {
        return (int) prizeNumbers.stream()
                .filter(lotto::has)
                .count();
    }

    public boolean has(BonusNumber bonusNumber) {
        return prizeNumbers.contains(bonusNumber.get());
    }
}
