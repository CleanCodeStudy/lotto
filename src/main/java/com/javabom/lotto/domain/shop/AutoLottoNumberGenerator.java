package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.number.GameNumber;
import com.javabom.lotto.domain.number.OrderGameNumber;
import com.javabom.lotto.domain.ticket.LottoTicket;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoNumberGenerator implements LottoNumbersGenerator {
    public static final List<GameNumber> GAME_NUMBERS = IntStream.rangeClosed(GameNumber.MIN_NUMBER, GameNumber.MAX_NUMBER)
            .mapToObj(GameNumber::valueOf)
            .collect(Collectors.toList());

    @Override
    public List<OrderGameNumber> generate() {
        final AtomicInteger idx = new AtomicInteger(1);

        Collections.shuffle(GAME_NUMBERS);
        return GAME_NUMBERS.stream()
                .map(number -> OrderGameNumber.of(idx.getAndIncrement(), number))
                .limit(LottoTicket.COUNT)
                .collect(Collectors.toList());
    }
}
