package com.javabom.lotto.domain.ticket;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoNumbers {

    private final List<Integer> numbers;

    public ManualLottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public LottoTicket toLottoTicket() {
        return new LottoTicket(numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        );
    }
}
