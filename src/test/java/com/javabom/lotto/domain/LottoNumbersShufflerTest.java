package com.javabom.lotto.domain;

import com.javabom.lotto.domain.shop.LottoNumberShuffler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersShufflerTest {

    @Test
    @DisplayName("1~45까지의 수 중에서 숫자 6개를 생성 하는지 확인.")
    public void getNumbersTest() {
        // given
        LottoNumberShuffler lottoNumberShuffler = new LottoNumberShuffler();

        assertEquals(6, lottoNumberShuffler.getNumbers().size());
    }

}