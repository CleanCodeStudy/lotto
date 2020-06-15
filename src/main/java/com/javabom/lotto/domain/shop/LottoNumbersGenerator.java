package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.number.OrderGameNumber;

import java.util.List;

public interface LottoNumbersGenerator {
    List<OrderGameNumber> generate();
}
