package com.javabom.lotto.domain.ticket;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberConverter {

    private LottoNumberConverter() {
    }

    public static List<LottoNumber> convert(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

}
