package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.number.GameNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoNumberGenerator implements LottoNumbersGenerator {
    public static final List<GameNumber> GAME_NUMBERS = IntStream.rangeClosed(GameNumber.MIN_NUMBER, GameNumber.MAX_NUMBER)
            .mapToObj(GameNumber::valueOf)
            .collect(Collectors.toList());

    @Override
    public List<GameNumber> generate() {
        Collections.shuffle(GAME_NUMBERS);
        return GAME_NUMBERS.stream()
                .limit(6)
                .collect(Collectors.toList());
    }
}
