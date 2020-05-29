package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.LottoNumbers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTicket extends LottoNumbers {

    private static final int LOTTO_NUM_PICK_SIZE = 6;

    public LottoTicket(List<LottoNumber> numbers) {
        super(numbers);
    }

    @Override
    protected void validateLottoNumbers(List<LottoNumber> numbers) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}
