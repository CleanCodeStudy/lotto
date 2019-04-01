package com.ccstudy.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;


public class LottoTicket {
    private List<LottoNo> lottoNumber;

    public LottoTicket(List<LottoNo> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber.stream()
                .map(LottoNo::getNumber)
                .sorted()
                .collect(Collectors.toList());
    }

    public int getAnswer(List<Integer> correctAnswer) {
        return (int) lottoNumber.stream()
                .map(LottoNo::getNumber)
                .filter(correctAnswer::contains)
                .count();
    }
}
