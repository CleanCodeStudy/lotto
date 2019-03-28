package com.ccstudy.lotto.domain;

import com.ccstudy.lotto.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos;

    public LottoGame(int purchase, List<Lotto> manualLottos, NumberGenerator numberGenerator) {
        this.lottos = createLottos(purchase, manualLottos, numberGenerator);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Lotto> createLottos(int purchase, List<Lotto> manualLottos, NumberGenerator numberGenerator) {
        int manualPurchas = manualLottos.size() * LOTTO_PRICE;
        int randomLottoCount = (purchase - manualPurchas) / LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();

        lottos.addAll(manualLottos);

        for (int i = 0; i < randomLottoCount; i++) {
            lottos.add(new Lotto(numberGenerator.getSixList()));
        }

        return lottos;
    }

    public LottoResult gameStart(WinningNumber winningNumber) {
        return new LottoResult(lottos, winningNumber);
    }
}
