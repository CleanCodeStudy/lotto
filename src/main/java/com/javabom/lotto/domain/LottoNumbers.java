package com.javabom.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final List<LottoNumber> numbers;

    public LottoNumbers(int gameMoney, NumberShuffler shuffler) {
        numbers = LottoNumberFactory.getLottoNumbers(gameMoney / LottoInfo.lottoPrice, shuffler);
    }

    public List<LottoRank> findLottoRanks(List<Integer> winningNumber, int bonusNumber) {
        return numbers.stream()
                .map(m -> {
                    int sameCountByWinnerNumber = m.getSameCountByWinnerNumber(winningNumber);
                    boolean hasBonusNumber = m.hasBonusNumber(bonusNumber);
                    return LottoRank.findLottoRank(sameCountByWinnerNumber, hasBonusNumber);
                })
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
