package com.javabom.lotto.domain.dto;

import com.javabom.lotto.domain.ticket.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberSeparator {

    private static final String DELIMITER = ",";

    public static List<LottoNumber> separate(String numbers) {
        checkEachNumber(numbers);
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers.split(DELIMITER))
                .map(String::trim)
                .map(number -> new LottoNumber(Integer.parseInt(number)))
                .collect(Collectors.toList());
        LottoNumbersValidator.validDuplicatedNumber(lottoNumbers);
        LottoNumbersValidator.validLottoNumberCount(lottoNumbers);
        return lottoNumbers;
    }

    private static void checkEachNumber(String numbers) {
        for (String number : numbers.split(DELIMITER)) {
            LottoNumberValidator.validLottoNumber(number.trim());
        }
    }
}
