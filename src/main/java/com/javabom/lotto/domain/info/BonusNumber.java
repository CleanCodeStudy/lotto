package com.javabom.lotto.domain.info;

import com.javabom.lotto.domain.valid.GameNumber;

public class BonusNumber {
    private final int VALID_COUNT = 5;

    private GameNumber bonusNumber;

    public BonusNumber(String strBonusNumber) {
        this.bonusNumber = new GameNumber(strBonusNumber);
    }

    public GameNumber get() {
        return bonusNumber;
    }

    public boolean isValid(Lotto lotto, int matchedCount) {
        return lotto.has(bonusNumber) && matchedCount == VALID_COUNT;
    }
}
