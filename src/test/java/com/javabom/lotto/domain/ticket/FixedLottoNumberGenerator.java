package com.javabom.lotto.domain.ticket;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FixedLottoNumberGenerator implements LottoNumberGenerator {
    @Override
    public List<LottoNumber> getLottoNumbers() {
        return IntStream.rangeClosed(1, 6)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
