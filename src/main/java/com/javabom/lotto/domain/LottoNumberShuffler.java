package com.javabom.lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberShuffler implements NumberShuffler {

    private final List<Integer> lottoNum;

    public LottoNumberShuffler() {
        lottoNum = Arrays.stream(IntStream.range(1, 46).toArray())
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> getNumbers() {
        Collections.shuffle(lottoNum);
        return Arrays.stream(IntStream.range(0, 6).toArray())
                .boxed()
                .map(lottoNum::get)
                .collect(Collectors.toList());
    }
}
