package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.dto.LottoNumberValidator;
import com.javabom.lotto.domain.dto.LottoNumbersValidator;
import com.javabom.lotto.domain.ticket.LottoNumber;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberShuffler implements LottoNumberGenerator {

    private final List<LottoNumber> lottoNum;

    public LottoNumberShuffler() {
        lottoNum = IntStream.rangeClosed(LottoNumberValidator.NUMBER_BEGIN, LottoNumberValidator.NUMBER_END)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public Set<LottoNumber> generate() {
        Collections.shuffle(lottoNum);
        return new HashSet<>(lottoNum.subList(0, LottoNumbersValidator.MAX_NUMBER_COUNT));

    }
}
