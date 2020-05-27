package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.info.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class RandomMachine {
    private final GenerateLottoNumbers generateLottoNumbers;

    public RandomMachine(GenerateLottoNumbers generateLottoNumbers) {
        this.generateLottoNumbers = generateLottoNumbers;
    }

    public Lotto createLotto() {
        List<Integer> lottoNumbers = generateLottoNumbers.generate();
        return new Lotto(picked(lottoNumbers));
    }

    private List<Integer> picked(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .limit(6)
                .collect(Collectors.toList());
    }
}
