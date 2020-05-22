package com.javabom.lotto.domain;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(String strBonusNumber, PrizeNumbers prizeNumbers) {
        int bonusNumber = parseInt(strBonusNumber);
        checkDuplicate(bonusNumber, prizeNumbers);
        checkRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private int parseInt(String strBonusNumber) {
        try {
            return Integer.parseInt(strBonusNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("보너스 번호는 숫자만 들어올 수 있습니다.");
        }
    }

    private void checkDuplicate(int bonusNumber, PrizeNumbers prizeNumbers) {
        if (prizeNumbers.has(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 이미 당첨 번호에 있는 번호입니다.");
        }
    }

    private void checkRange(int bonusNumber) {
        if (isNotRange(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45까지만 있을 수 있습니다.");
        }
    }

    private boolean isNotRange(int bonusNumber) {
        return bonusNumber < 1 || bonusNumber > 45;
    }

    public boolean isValid(Lotto lotto, int matchedCount) {
        if (valid(lotto, matchedCount)) {
            return true;
        }
        return false;
    }

    private boolean valid(Lotto lotto, int matchedCount) {
        return lotto.has(bonusNumber) && matchedCount == 5;
    }

    public int get() {
        return bonusNumber;
    }
}
