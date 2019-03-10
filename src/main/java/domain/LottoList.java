package domain;

import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos;

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoList(int price) {
        this.lottos = buyLotto(price);
    }

    private List<Lotto> buyLotto(int price) {
        int lottoAmount = price/LOTTO_PRICE;
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i <lottoAmount ; i++) {
            lottos.add(new Lotto(randomNumberGenerator));
        }

        return lottos;
    }


}

