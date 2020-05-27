package com.javabom.lotto.domain.info;

import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.result.LottoResultBundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBundle {

    private final List<Lotto> lottoBundle;

    public LottoBundle(List<Lotto> myLottoBundle) {
        this.lottoBundle = myLottoBundle;
    }

    public LottoResultBundle confirmLottoResult(PrizeNumberInfo prizeNumberInfo) {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (Lotto lotto : lottoBundle) {
            LottoResult result = prizeNumberInfo.matchLotto(lotto);
            lottoResults.add(result);
        }
        return new LottoResultBundle(lottoResults);
    }

    public List<Lotto> getMyLottoBundle() {
        return Collections.unmodifiableList(lottoBundle);
    }
}
