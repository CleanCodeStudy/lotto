package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.dto.BonusNumberDto;
import com.javabom.lotto.domain.dto.WinningNumbersDto;

import java.util.Set;

public class WinningTicket {

    private final Set<LottoNumber> winningNumbers;

    private final LottoNumber bonusNumber;

    public WinningTicket(WinningNumbersDto winningNumbersDto, BonusNumberDto bonusNumberDto) {
        this.winningNumbers = winningNumbersDto.getWinningNumbers();
        this.bonusNumber = bonusNumberDto.getBonusNumber();
        validDuplicatedNumbers();
    }

    private void validDuplicatedNumbers() {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호에 보너스 번호가 중복된 번호가 존재합니다.");
        }
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }

    public boolean isSameBonusNumber(LottoNumber lottoNumber) {
        return bonusNumber.equals(lottoNumber);
    }
}
