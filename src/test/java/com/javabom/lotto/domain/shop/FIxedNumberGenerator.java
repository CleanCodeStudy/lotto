package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.number.GameNumber;
import com.javabom.lotto.domain.utils.GameNumberConverter;

import java.util.Arrays;
import java.util.List;

public class FIxedNumberGenerator implements LottoNumbersGenerator{

    List<String> strGameNumbers = Arrays.asList("1","2","3","4","5","6");

    @Override
    public List<GameNumber> generate() {
        return GameNumberConverter.convert(strGameNumbers);
    }
}
