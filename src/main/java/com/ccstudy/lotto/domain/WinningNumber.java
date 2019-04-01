package com.ccstudy.lotto.domain;

import java.util.List;

public class WinningNumber {
    private List<Integer> correctNumbers;
    private int bonusNumber;

    public WinningNumber(List<Integer> correctNumbers, int bonusNumber) {
        this.correctNumbers = correctNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isCorrectBonus(LottoTicket lottoTicket) {
        return (lottoTicket.getLottoNumber().contains(bonusNumber));
    }

    public int getAnswerCount(LottoTicket lottoTicket) {
        return (int) lottoTicket.getLottoNumber()
                .stream()
                .filter(correctNumbers::contains)
                .count();
    }
}
