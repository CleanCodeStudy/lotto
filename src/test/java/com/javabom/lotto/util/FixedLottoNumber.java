package com.javabom.lotto.util;

import java.util.Arrays;
import java.util.List;

public class FixedLottoNumber implements PickedLottoNumbers {

    @Override
    public List<Integer> picked() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }
}
