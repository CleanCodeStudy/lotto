package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.ticket.LottoNumber;
import com.javabom.lotto.domain.ticket.LottoNumberSetting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoNumberShufflerTest {

    @Test
    @DisplayName("자동으로 로또 번호 6개를 생성하는지 확인.")
    void generateNumberCountTest() {
        LottoNumberShuffler shuffler = new LottoNumberShuffler();

        assertEquals(LottoNumberSetting.MAX_NUMBER_COUNT, shuffler.generate().size());
    }

    @Test
    @DisplayName("설정된 로또 번호 범위에 맞게 생성하는지 확인.")
    void generateTest() {
        LottoNumberShuffler shuffler = new LottoNumberShuffler();
        Set<LottoNumber> generate = shuffler.generate();
        int maxNumber = generate.stream()
                .max(Comparator.comparing(LottoNumber::getNumber))
                .get()
                .getNumber();

        int minNumber = generate.stream()
                .min(Comparator.comparing(LottoNumber::getNumber))
                .get()
                .getNumber();

        assertTrue(maxNumber <= LottoNumberSetting.NUMBER_END);
        assertTrue(minNumber >= LottoNumberSetting.NUMBER_BEGIN);
    }
}