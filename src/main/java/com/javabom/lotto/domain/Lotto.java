package com.javabom.lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public boolean has(int lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public int get(int idx) {
        return lotto.get(idx);
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(lotto);
    }
}
