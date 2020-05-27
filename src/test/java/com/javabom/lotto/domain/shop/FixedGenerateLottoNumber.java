package com.javabom.lotto.domain.shop;

import java.util.Arrays;
import java.util.List;

public class FixedGenerateLottoNumber implements GenerateLottoNumbers {

    @Override
    public List<Integer> picked() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }
}
