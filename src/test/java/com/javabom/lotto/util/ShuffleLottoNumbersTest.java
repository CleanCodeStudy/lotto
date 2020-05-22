package com.javabom.lotto.util;

import com.javabom.lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShuffleLottoNumbersTest {

    @DisplayName("랜덤으로 값을 뽑았을 때 6개의 값이 잘 나오는지 확인한다.")
    @Test
    public void picked() {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Lotto> lottoBundle = LottoFactory.createLotto(1, new FixedLottoNumber());
        Lotto actual = lottoBundle.get(0);

        assertEquals(expected.get(0), actual.get(0));
        assertEquals(expected.get(1), actual.get(1));
        assertEquals(expected.get(2), actual.get(2));
        assertEquals(expected.get(3), actual.get(3));
        assertEquals(expected.get(4), actual.get(4));
        assertEquals(expected.get(5), actual.get(5));
    }
}