package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.ticket.LottoNumber;

import java.util.Set;

public interface LottoNumberGenerator {

    Set<LottoNumber> generate();
}
