package com.javabom.lotto.domain.dto;

import com.javabom.lotto.domain.ticket.LottoNumber;
import com.javabom.lotto.domain.shop.LottoShop;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningTicketDto {

    private final List<LottoNumber> winningTicket;

    public WinningTicketDto(String numbers) {
        List<LottoNumber> winningNumbers = LottoNumberSeparator.separate(numbers);
        validNumbers(winningNumbers);
        this.winningTicket = winningNumbers;
    }

    private void validNumbers(List<LottoNumber> winningNumbers) {
        validDuplicatedNumber(winningNumbers);
        validWinningNumberCount(winningNumbers);
    }

    private void validDuplicatedNumber(List<LottoNumber> winningNumber) {
        Set<LottoNumber> set = new HashSet<>(winningNumber);
        if (set.size() != winningNumber.size()) {
            throw new IllegalArgumentException("당첨번호에 중복된 번호가 존재합니다.");
        }
    }

    private void validWinningNumberCount(List<LottoNumber> winningNumber) {
        if (winningNumber.size() != LottoShop.MAX_NUMBER_COUNT) {
            throw new IllegalArgumentException("입력된 당첨 번호 수가 6개가 아닙니다.");
        }
    }

    public List<LottoNumber> getWinningTicket() {
        return winningTicket;
    }
}
