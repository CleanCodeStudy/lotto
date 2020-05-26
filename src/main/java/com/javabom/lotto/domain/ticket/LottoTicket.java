package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.LottoNumberSetting;
import com.javabom.lotto.domain.result.LottoPrize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {
    private final Set<Integer> lottoNumbers;

    public LottoTicket(Set<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private static boolean isValidNumber(Integer number) {
        return number >= LottoNumberSetting.BEGIN_BOUND.getValue()
                && number <= LottoNumberSetting.END_BOUND.getValue();
    }

    private void validate(Set<Integer> lottoNumbers) {
        Set<Integer> validLottoNumbers = lottoNumbers.stream()
                .filter(LottoTicket::isValidNumber)
                .collect(Collectors.toSet());
        if (validLottoNumbers.size() != LottoNumberSetting.COUNT_OF_BALL.getValue()) {
            throw new IllegalArgumentException("로또번호는 중복이 없는 6개의 1과 45사이의 숫자여야 합니다");
        }
    }

    public LottoPrize calculateLottoPrize(LottoTicket winningTicket) {
        int matchCount = Math.toIntExact(lottoNumbers.stream()
                .filter(winningTicket::contains)
                .count());

        return LottoPrize.findByMathCount(matchCount);
    }

    public boolean contains(int number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public String toString() {
        List<Integer> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(sortedLottoNumbers);
        return String.valueOf(sortedLottoNumbers);
    }
}
