package com.javabom.lotto.domain.dto;

import com.javabom.lotto.domain.ticket.LottoNumber;

public class BonusNumberDto {

    LottoNumber bonusNumber;

    public BonusNumberDto(String bonusNumber) {
        LottoNumberValidator.validLottoNumber(bonusNumber);
        this.bonusNumber = new LottoNumber(Integer.parseInt(bonusNumber));
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
