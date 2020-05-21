package com.javabom.lotto.domain.ticket;

import java.util.Arrays;
import java.util.List;

public class FixedLottoNumberGenerator implements LottoNumberGenerator {
    @Override
    public List<LottoNumber> getLottoNumbers() {
        return Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));
    }
}
