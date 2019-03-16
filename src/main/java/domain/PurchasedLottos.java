package domain;

import domain.result.PurchasedResult;
import util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos {
    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottos;
    private long price;

    public PurchasedLottos(long price, NumberGenerator numberGenerator) {
        this.lottos = buyLotto(price, numberGenerator);
        this.price = price;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public long getPrice() {
        return price;
    }

    private List<Lotto> buyLotto(long price, NumberGenerator numberGenerator) {
        long amountOfLotto = price / LOTTO_PRICE;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amountOfLotto; i++) {
            lottos.add(new Lotto(numberGenerator));
        }

        return lottos;
    }

    public PurchasedResult confirmLottos(PurchasedLottos purchasedLottos, List<String> inputWinningNumber) {
        return new PurchasedResult(purchasedLottos,inputWinningNumber);
    }
}

