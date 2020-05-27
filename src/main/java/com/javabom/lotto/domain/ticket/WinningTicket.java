package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.dto.BonusNumberDto;
import com.javabom.lotto.domain.dto.WinningTicketDto;

import java.util.Collections;
import java.util.List;

public class WinningLottoNumbers {

    private final List<LottoNumber> winningTicket;

    private final LottoNumber bonusNumber;

    public WinningLottoNumbers(WinningTicketDto winningTicketDto, BonusNumberDto bonusNumberDto) {
        this.winningTicket = winningTicketDto.getWinningTicket();
        this.bonusNumber = bonusNumberDto.getBonusNumber();
    }

    public boolean isSameBonusNumber(final int number) {
        return bonusNumber.getNumber() == number;
    }

    public List<LottoNumber> getWinningTicket() {
        return Collections.unmodifiableList(winningTicket);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
