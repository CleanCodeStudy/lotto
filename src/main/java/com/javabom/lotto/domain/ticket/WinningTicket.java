package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.dto.BonusNumberDto;
import com.javabom.lotto.domain.dto.WinningTicketDto;

import java.util.List;

public class WinningTicket {

    private final List<LottoNumber> winningNumbers;

    private final LottoNumber bonusNumber;

    public WinningTicket(WinningTicketDto winningTicketDto, BonusNumberDto bonusNumberDto) {
        this.winningNumbers = winningTicketDto.getWinningTicket();
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
