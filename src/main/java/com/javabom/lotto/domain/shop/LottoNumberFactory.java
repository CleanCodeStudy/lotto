package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.lottery.LottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberFactory {

    public static List<LottoNumbers> getLottoNumbers(int lottoCount, NumberShuffler shuffler) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers.add(new LottoNumbers(shuffler.getNumbers()));
        }

        return lottoNumbers;
    }

}
