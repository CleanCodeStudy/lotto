package com.javabom.lotto.domain.results;

import com.javabom.lotto.domain.LottoNumbers;
import com.javabom.lotto.domain.ticket.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoBasicLuckyNumbers extends LottoNumbers {

    private static final int LUCKY_LOTTO_NUM_SIZE = 6;

    public LottoBasicLuckyNumbers(List<Integer> numbers) {
        super(convertToLottoNumbers(numbers));
    }

    private static List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    protected void validateLottoNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != LUCKY_LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 반드시 6개입니다.");
        }
    }
}
