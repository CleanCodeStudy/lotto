package com.javabom.lotto.domain.result;

import static com.javabom.lotto.domain.LottoNumberSetting.NUMBER_BEGIN_BOUND;
import static com.javabom.lotto.domain.LottoNumberSetting.NUMBER_END_BOUND;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        if (isValidNumber(number)) {
            throw new IllegalArgumentException("보너스번호는 1이상 45이하여야합니다");
        }
        this.number = number;
    }

    private boolean isValidNumber(int number) {
        return number < NUMBER_BEGIN_BOUND || number > NUMBER_END_BOUND;
    }

    public int getNumber() {
        return this.number;
    }

    public boolean isSameNumber(final int number) {
        return this.number == number;
    }
}
