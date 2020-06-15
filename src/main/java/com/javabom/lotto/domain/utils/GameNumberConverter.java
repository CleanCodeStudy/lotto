package com.javabom.lotto.domain.utils;

import com.javabom.lotto.domain.number.OrderGameNumber;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class GameNumberConverter {

    public static List<OrderGameNumber> convert(List<String> strGameNumbers) {
        final AtomicInteger idx = new AtomicInteger(1);

        return strGameNumbers.stream()
                .distinct()
                .map(number -> OrderGameNumber.of(idx.getAndIncrement(), number.trim()))
                .collect(Collectors.toList());
    }
}
