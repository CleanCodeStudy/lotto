package com.javabom.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {

    private final List<Integer> lottoNumber;

    public LottoNumber(NumberShuffler shuffler) {
        lottoNumber = shuffler.getNumbers();
    }

    public int getSameCountByWinnerNumber(List<Integer> winningNumber) {
        return (int) lottoNumber.stream()
                .filter(winningNumber::contains).count();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return lottoNumber.contains(bonusNumber);
    }

    public List<Integer> getLottoNumber() {
        return new ArrayList<>(lottoNumber);
    }

    @Override
    public String toString() {
        return "" + lottoNumber;
    }
}
