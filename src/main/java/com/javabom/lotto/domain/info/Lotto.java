package com.javabom.lotto.domain.info;

import com.javabom.lotto.domain.valid.GameNumber;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public boolean has(GameNumber gameNumber) {
        return lotto.contains(gameNumber.get());
    }

    public int get(int idx) {
        return lotto.get(idx);
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(lotto);
    }
}
