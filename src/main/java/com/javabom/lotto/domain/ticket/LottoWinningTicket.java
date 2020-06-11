package com.javabom.lotto.domain.ticket;


import com.javabom.lotto.domain.WinningSheet;
import com.javabom.lotto.domain.number.LottoNumber;

import java.util.List;

public class LottoWinningTicket {
    private final LottoTicket winningTicket;
    private final LottoNumber bonusNumber;

    public LottoWinningTicket(List<Integer> winningNumbers, int bonusNumber) {
        validateDuplicateBonusNumber(winningNumbers, bonusNumber);

        this.winningTicket = LottoTicket.ofFixed(winningNumbers);
        this.bonusNumber = LottoNumber.valueOf(bonusNumber);
    }

    private void validateDuplicateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복 될 수 없습니다. - " + bonusNumber);
        }
    }

    public WinningSheet findMatchingSheet(LottoTicket lottoTicket) {
        return WinningSheet.findByMatchCount(lottoTicket.findMatchCount(winningTicket)
                , lottoTicket.isContainingLottoNumbers(bonusNumber));
    }
}
