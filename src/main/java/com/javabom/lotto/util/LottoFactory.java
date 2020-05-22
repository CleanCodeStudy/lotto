package com.javabom.lotto.util;

import com.javabom.lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    public static List<Lotto> createLotto(int lottoCount, PickedLottoNumbers pikedLottoNumber) {
        List<Lotto> lottoBundle = new ArrayList<>();
        for (int curLottoCount = 0; curLottoCount < lottoCount; curLottoCount++) {
            lottoBundle.add(new Lotto(pikedLottoNumber.picked()));
        }
        return lottoBundle;
    }
}
