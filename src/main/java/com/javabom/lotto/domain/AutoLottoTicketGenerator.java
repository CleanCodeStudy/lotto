package com.javabom.lotto.domain;

import java.util.concurrent.ThreadLocalRandom;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class AutoLottoTicketGenerator {
    private static final int LOTTO_NUMBER_START_BOUND = 1;
    private static final int LOTTO_NUMBER_END_BOUND = 45;
    private static final int COUNT_OF_LOTTO_NUMBER = 6;

    public static LottoTicket generate() {
        return ThreadLocalRandom.current()
                .ints(LOTTO_NUMBER_START_BOUND, LOTTO_NUMBER_END_BOUND)
                .limit(COUNT_OF_LOTTO_NUMBER)
                .boxed()
                .collect(collectingAndThen(toList(), LottoTicket::new));
    }
}
