package com.ccstudy.lotto.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FixedGeneratorImpl implements NumberGenerator {
    private List<Integer> lottoRange = IntStream.range(1, 45)
            .mapToObj(Integer::new)
            .collect(Collectors.toList());
    private int startIndex;

    public FixedGeneratorImpl(int startIndex) {
        this.startIndex = startIndex;
    }

    @Override
    public List<Integer> getSixList() {
        List<Integer> sixList;

        sixList = lottoRange.stream()
                .skip(startIndex)
                .limit(6)
                .collect(Collectors.toList());

        startIndex++;

        return sixList;
    }
}
