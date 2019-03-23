package com.ccstudy.lotto.domain;

import org.junit.Test;
import com.ccstudy.lotto.util.FixedGeneratorImpl;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LottoTest {

    @Test
    public void 로또_3개_정답_테스트() {
        FixedGeneratorImpl fixedListGenerator = new FixedGeneratorImpl(0);
        Lotto myLotto = new Lotto(fixedListGenerator.getSixList());
        assertEquals(4, myLotto.getAnswer(Arrays.asList(1, 2, 4, 8, 3, 10)));
    }
}