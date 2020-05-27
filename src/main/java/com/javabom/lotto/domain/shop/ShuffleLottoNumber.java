package com.javabom.lotto.domain.shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ShuffleLottoNumber implements GenerateLottoNumbers {
    private static final List<Integer> LOTTO_NUMBER = new ArrayList<>();

    static {
        init();
    }

    private static void init() {
        for (int number = 1; number <= 45; number++) {
            LOTTO_NUMBER.add(number);
        }
    }

    @Override
    public List<Integer> picked() {
        Collections.shuffle(LOTTO_NUMBER);
        return LOTTO_NUMBER.stream()
                .limit(6)
                .collect(Collectors.toList());
    }
}
