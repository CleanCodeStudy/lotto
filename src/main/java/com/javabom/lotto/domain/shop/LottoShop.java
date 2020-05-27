package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.info.Lotto;
import com.javabom.lotto.domain.info.LottoBundle;
import com.javabom.lotto.domain.vo.Money;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private final int LOTTO_PRICE = 1000;

    private final RandomMachine randomMachine;

    public LottoShop(RandomMachine randomMachine) {
        this.randomMachine = randomMachine;
    }

    public LottoBundle buyLotto(Money money) {
        checkCanBuyLotto(money.get());
        List<Lotto> lottoBundle = new ArrayList<>();
        for (int i = 1; i <= getLottoCount(money.get()); i++) {
            lottoBundle.add(randomMachine.createLotto());
        }
        return new LottoBundle(lottoBundle);
    }

    private void checkCanBuyLotto(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("돈이 부족합니다. 1000원 이상 금액을 입력해 주세요.");
        }
    }

    public int getLottoCount(int money) {
        return money / LOTTO_PRICE;
    }
}
