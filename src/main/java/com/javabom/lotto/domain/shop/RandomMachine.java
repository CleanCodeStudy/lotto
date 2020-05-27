package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.info.Lotto;

public class RandomMachine {
    private final GenerateLottoNumbers generateLottoNumbers;

    public RandomMachine(GenerateLottoNumbers generateLottoNumbers) {
        this.generateLottoNumbers = generateLottoNumbers;
    }

    public Lotto createLotto() {
        return new Lotto(generateLottoNumbers.picked());
    }
}
