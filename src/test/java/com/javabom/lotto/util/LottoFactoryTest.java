package com.javabom.lotto.util;

import com.javabom.lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {

    @DisplayName("로또가 입력 갯수만큼 생성되는지 확인한다.")
    @Test
    void createLotto() {
        int expected = 3;
        List<Lotto> actual = LottoFactory.createLotto(expected, new FixedLottoNumber());
        assertEquals(expected, actual.size());
    }
}