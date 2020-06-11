package com.javabom.lotto.domain.ticket;

import java.util.List;

public class WinningTicket {

    private final List<LottoNumber> winningNumbers;

    private final LottoNumber bonusNumber;

    public WinningTicket(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
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

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }
}
