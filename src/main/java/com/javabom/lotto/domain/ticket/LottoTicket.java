package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.result.LottoPrize;
import com.javabom.lotto.domain.result.WinningTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.javabom.lotto.domain.LottoNumberSetting.*;

public class LottoTicket {
    private final Set<Integer> lottoNumbers;

    public LottoTicket(Set<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private static boolean isValidNumber(Integer number) {
        return number >= NUMBER_BEGIN_BOUND && number <= NUMBER_END_BOUND;
    }

    private void validate(Set<Integer> lottoNumbers) {
        Set<Integer> validLottoNumbers = lottoNumbers.stream()
                .filter(LottoTicket::isValidNumber)
                .collect(Collectors.toSet());
        if (validLottoNumbers.size() != COUNT_OF_NUMBER) {
            throw new IllegalArgumentException("로또번호는 중복이 없는 6개의 1과 45사이의 숫자여야 합니다");
        }
    }

    public LottoPrize calculateLottoPrize(WinningTicket winningTicket) {
        int matchCount = Math.toIntExact(lottoNumbers.stream()
                .filter(winningTicket::contains)
                .count());
        boolean matchBonus = lottoNumbers.stream()
                .anyMatch(winningTicket::matchBonus);

        return LottoPrize.findByMathCount(matchCount, matchBonus);
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
