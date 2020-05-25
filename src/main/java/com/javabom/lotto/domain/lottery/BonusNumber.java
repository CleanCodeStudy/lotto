package com.javabom.lotto.domain.lottery;

import com.javabom.lotto.domain.LottoNumberValidator;

public class BonusNumber {

    private LottoNumber bonusNumber;

    public BonusNumber(String bonusNumber) {
        LottoNumberValidator.validLottoNumber(bonusNumber);
        this.bonusNumber = new LottoNumber(Integer.parseInt(bonusNumber));
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
