package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.ticket.LottoNumber;
import com.javabom.lotto.domain.ticket.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoNumberShufflerTest {

    @Test
    @DisplayName("자동으로 로또 번호 6개를 생성하는지 확인.")
    void generateNumberCountTest() {
        LottoNumbersGenerator shuffler = new LottoNumbersGenerator();

        assertEquals(LottoTicket.LOTTO_NUMBER_COUNT, shuffler.generate().size());
    }

    @Test
    @DisplayName("설정된 로또 번호 범위에 맞게 생성하는지 확인.")
    void generateTest() {
        LottoNumbersGenerator shuffler = new LottoNumbersGenerator();
        List<LottoNumber> generate = shuffler.generate();
        int maxNumber = generate.stream()
                .max(Comparator.comparing(LottoNumber::getNumber))
                .get()
                .getNumber();

        int minNumber = generate.stream()
                .min(Comparator.comparing(LottoNumber::getNumber))
                .get()
                .getNumber();

        assertTrue(maxNumber <= LottoNumber.NUMBER_END);
        assertTrue(minNumber >= LottoNumber.NUMBER_BEGIN);
    }

    @Test
    @DisplayName("입력된 숫자값을 로또번호로 변환하는지 확인.")
    public void convertLottoNumberTest() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        List<LottoNumber> convertToLottoNumbers = LottoNumbersGenerator.convertToLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertEquals(lottoNumbers, convertToLottoNumbers);
    }
}