package com.ccstudy.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNo {
    private static List<Integer> lottoRange = IntStream.range(1, 45)
            .mapToObj(Integer::new)
            .collect(Collectors.toList());
    private Integer number;

    public LottoNo(Integer number) {
        validateBound(number);
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void validateBound(Integer number) {
        if (!lottoRange.contains(number)) {
            throw new RuntimeException("로또번호는 1 ~ 45 사이의 번호여야 합니다.");
        }
    }
}
