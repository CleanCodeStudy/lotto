package com.javabom.lotto.domain.ticket;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int LOTTO_NUM_PICK_SIZE = 6;

    private final List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) {
        validateListSize(numbers);
        this.numbers = numbers;
    }

    void validateListSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUM_PICK_SIZE) {
            throw new IllegalArgumentException("로또 티켓에 6개 숫자를 넣어야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::get)
                .collect(Collectors.toList());
    }

    public boolean isContain(LottoNumber number) {
        return numbers.contains(number);
    }
}
