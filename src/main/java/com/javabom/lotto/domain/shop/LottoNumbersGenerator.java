package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.ticket.LottoNumber;
import com.javabom.lotto.domain.ticket.LottoTicket;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersGenerator {

    private final List<LottoNumber> lottoNum;

    public LottoNumbersGenerator() {
        lottoNum = IntStream.rangeClosed(LottoNumber.NUMBER_BEGIN, LottoNumber.NUMBER_END)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> generate() {
        Collections.shuffle(lottoNum);
        return new ArrayList<LottoNumber>(lottoNum.subList(0, LottoTicket.LOTTO_NUMBER_COUNT)) {
        };
    }

    public static List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
