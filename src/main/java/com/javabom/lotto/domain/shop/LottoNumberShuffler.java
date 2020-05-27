package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.lottery.LottoNumber;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoLottoNumberGenerator implements LottoNumberGenerator {

    private final List<LottoNumber> lottoNum;

    public LottoLottoNumberGenerator() {
        lottoNum = Arrays.stream(IntStream.range(LottoShop.MIN_NUMBER, LottoShop.MAX_NUMBER).toArray())
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<LottoNumber> getNumbers() {
        Collections.shuffle(lottoNum);
        return Arrays.stream(IntStream.range(0, LottoShop.MAX_LOTTERY_COUNT).toArray())
                .boxed()
                .map(lottoNum::get)
                .collect(Collectors.toList());
    }
}
