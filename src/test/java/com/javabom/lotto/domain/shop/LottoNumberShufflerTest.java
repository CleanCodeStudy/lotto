package com.javabom.lotto.domain.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberShufflerTest {

    @Test
    void generateTest() {
        LottoNumberShuffler shuffler = new LottoNumberShuffler();

        assertEquals(6, shuffler.generate().size());
    }
}