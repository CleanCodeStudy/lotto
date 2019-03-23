package com.ccstudy.lotto.domain;

import com.ccstudy.lotto.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos;

    public LottoGame(int purchase, NumberGenerator numberGenerator) {
        this.lottos = createLottos(purchase, numberGenerator);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Lotto> createLottos(int purchase, NumberGenerator numberGenerator) {
        int lottoCount = purchase/LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0 ; i < lottoCount ; i++){
            lottos.add(new Lotto(numberGenerator.getSixList()));
        }

        return lottos;
    }

    public LottoResult gameStart(List<Integer> correctAnswer){
        return new LottoResult(lottos,correctAnswer);
    }
}
