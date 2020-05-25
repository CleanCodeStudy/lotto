package com.javabom.lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    public static final int PRICE = 1000;
    private static final int NUMBER_OF_LOTTO_NUMBER = 6;

    private final List<Integer> lottoNumbers;

    public LottoTicket(final List<Integer> lottoNumbers) {
        if (isValidSizeOf(lottoNumbers)) {
            throw new IllegalArgumentException(String.format("로또숫자는 %d개로 이루어져야합니다!", NUMBER_OF_LOTTO_NUMBER));
        }
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public int getHitRate(List<Integer> winningNumbers) {
        return Math.toIntExact(lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    private boolean isValidSizeOf(List<Integer> lottoNumbers) {
        return lottoNumbers.size() != NUMBER_OF_LOTTO_NUMBER;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

}
