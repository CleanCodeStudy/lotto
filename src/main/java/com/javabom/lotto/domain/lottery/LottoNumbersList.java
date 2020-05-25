package com.javabom.lotto.domain.lottery;

import com.javabom.lotto.domain.LottoInformation;
import com.javabom.lotto.domain.shop.LottoNumberFactory;
import com.javabom.lotto.domain.shop.NumberShuffler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersList {

    private final List<LottoNumbers> numbers;

    public LottoNumbersList(int gameMoney, NumberShuffler shuffler) {
        int lottoCount = gameMoney / LottoInformation.lottoPrice;
        numbers = LottoNumberFactory.getLottoNumbers(lottoCount, shuffler);
    }

    public List<LottoRank> findLottoRanks(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return numbers.stream()
                .map(lottoNumbers ->
                        LottoRank.findLottoRank(lottoNumbers.getSameCountByWinnerNumber(winningNumbers.getNumbers()), lottoNumbers.hasBonusNumber(bonusNumber.getBonusNumber())))
                .collect(Collectors.toList());
    }

    public List<LottoNumbers> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int size() {
        return numbers.size();
    }
}
