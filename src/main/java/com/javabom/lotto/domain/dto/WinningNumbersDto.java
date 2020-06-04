package com.javabom.lotto.domain.dto;

import com.javabom.lotto.domain.ticket.LottoNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbersDto {

    private final Set<LottoNumber> winningNumbers;

    public WinningNumbersDto(String numbers) {
        List<LottoNumber> winningNumbers = LottoNumberSeparator.separate(numbers);
        validNumbers(winningNumbers);
        this.winningNumbers = new HashSet<>(winningNumbers);
    }

    private void validNumbers(List<LottoNumber> winningNumbers) {
        LottoNumbersValidator.validDuplicatedNumber(winningNumbers);
        LottoNumbersValidator.validLottoNumberCount(winningNumbers);
    }

    public Set<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }
}
