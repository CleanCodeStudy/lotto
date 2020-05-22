package com.javabom.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyLottoBundle {
    private static final int BONUS_COUNT = 45;

    private final List<Lotto> myLottoBundle;

    public MyLottoBundle(List<Lotto> myLottoBundle) {
        this.myLottoBundle = myLottoBundle;
    }

    private int getMatchedCount(Lotto lotto, int matchedCount, BonusNumber bonusNumber) {
        if (bonusNumber.isValid(lotto, matchedCount)) {
            return matchedCount + BONUS_COUNT;
        }
        return matchedCount;
    }

    public List<Integer> getMatchedCounts(PrizeNumbers prizeNumbers, BonusNumber bonusNumber) {
        List<Integer> matchedCounts = new ArrayList<>();
        for (Lotto lotto : myLottoBundle) {
            matchedCounts.add(getMatchedCount(lotto, prizeNumbers.getMatchedCount(lotto), bonusNumber));
        }
        return matchedCounts;
    }

    public List<Lotto> getMyLottoBundle() {
        return Collections.unmodifiableList(myLottoBundle);
    }
}
