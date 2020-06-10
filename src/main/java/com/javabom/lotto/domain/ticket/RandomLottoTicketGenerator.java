package com.javabom.lotto.domain.ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoTicketGenerator implements LottoTicketGenerator {

    private static final int LOTTO_NUM_PICK_SIZE = 6;

    private final List<LottoNumber> sortedLottoNumbers;

    public RandomLottoTicketGenerator() {
        sortedLottoNumbers = createSortedLottoNumbers();
    }

    private List<LottoNumber> createSortedLottoNumbers() {
        return IntStream.rangeClosed(LottoNumber.MIN_LOTTO_NUM, LottoNumber.MAX_LOTTO_NUM)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public LottoTicket getLottoTicket() {
        List<LottoNumber> numbers = new ArrayList<>(sortedLottoNumbers);
        Collections.shuffle(numbers);
        return new LottoTicket(numbers.subList(0, LOTTO_NUM_PICK_SIZE));
    }
}
