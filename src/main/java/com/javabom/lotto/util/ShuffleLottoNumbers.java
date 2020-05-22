package com.javabom.lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ShuffleLottoNumbers implements PickedLottoNumbers {
    private static final List<Integer> lottoNumbers = new ArrayList<>();

    static {
        init();
    }

    private static void init() {
        for (int number = 1; number <= 45; number++) {
            lottoNumbers.add(number);
        }
    }

    @Override
    public List<Integer> picked() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream()
                .limit(6)
                .collect(Collectors.toList());
    }
}
