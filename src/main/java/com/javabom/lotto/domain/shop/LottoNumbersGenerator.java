package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.number.GameNumber;

import java.util.List;

public interface LottoNumbersGenerator {
    List<GameNumber> generate();
}
