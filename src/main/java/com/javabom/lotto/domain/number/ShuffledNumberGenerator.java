package com.javabom.lotto.domain.number;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShuffledNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generate(int min, int max) {
        List<Integer> numbers = IntStream.rangeClosed(min, max)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);

        return numbers;
    }
}
