package com.javabom.lotto.domain.number;

import java.util.List;

public interface NumberGenerator {
    List<Integer> generate(int min, int max);
}
