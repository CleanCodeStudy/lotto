package com.javabom.lotto.domain.compare;

import com.javabom.lotto.domain.ticket.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBasicLuckyNumbers {

    private static final int LUCKY_LOTTO_NUM_SIZE = 6;

    private final List<LottoNumber> numbers;

    public LottoBasicLuckyNumbers(List<Integer> numbers) {
        validateLottoNumbersSize(numbers);
        this.numbers = convertToLottoNumbers(numbers);
    }
    // 로또 당첨번호가 로또 번호를 변환하는 코드를 가진다? 뭔가 이상해보입니다.
    // 차라리 외부에서 LottoNumberConverter 라는 클래스를 만든뒤, 거기에서 List<LottoNumber>를 반환받는게
    // 좀더 나아보일까요?

    private void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LUCKY_LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 반드시 6개입니다.");
        }
    }

    private List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> get() {
        return Collections.unmodifiableList(numbers);
    }
}
