package com.javabom.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class    LottoNumberFactory {

    public static List<LottoNumber> getLottoNumbers(int lottoCount, NumberShuffler shuffler) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers.add(new LottoNumber(shuffler));
        }

        return lottoNumbers;
    }

}
