package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.lottery.LottoNumber;
import com.javabom.lotto.domain.lottery.LottoNumbers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberShuffler implements NumberShuffler {

    private final List<LottoNumber> lottoNum;

    public LottoNumberShuffler() {
        lottoNum = Arrays.stream(IntStream.range(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER).toArray())
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<LottoNumber> getNumbers() {
        Collections.shuffle(lottoNum);
        return Arrays.stream(IntStream.range(0, LottoNumbers.MAX_LOTTO_COUNTS).toArray())
                .boxed()
                .map(lottoNum::get)
                .collect(Collectors.toList());
    }
}
