package com.ccstudy.lotto.domain;

import com.ccstudy.lotto.util.NumberListGenerator;
import com.ccstudy.lotto.util.RandomListGeneratorImpl;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<Lotto> lottos;

    public LottoGame(int purchase,NumberListGenerator numberListGenerator) {
        this.lottos = createLottos(purchase,numberListGenerator);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Lotto> createLottos(int purchase, NumberListGenerator numberListGenerator){
        int lottoCount = purchase/LottoResult.LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0 ; i < lottoCount ; i++){
            lottos.add(new Lotto(numberListGenerator.getSixList()));
        }

        return lottos;
    }

    public LottoResult gameStart(List<Integer> correctAnswer){
        return new LottoResult(lottos,correctAnswer);
    }
}
