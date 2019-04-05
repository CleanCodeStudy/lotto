package com.ccstudy.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;


public class LottoTicket {
    private List<LottoNo> lottoNumbers;

    public LottoTicket(List<LottoNo> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNo::getNumber)
                .sorted()
                .collect(Collectors.toList());
    }

    public int getAnswer(List<Integer> correctAnswer) {
        return (int) lottoNumbers.stream()
                .map(LottoNo::getNumber)
                .filter(correctAnswer::contains)
                .count();
    }
}
