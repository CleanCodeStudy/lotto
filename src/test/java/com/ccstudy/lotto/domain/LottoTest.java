package com.ccstudy.lotto.domain;

import org.junit.Test;
import com.ccstudy.lotto.util.FixedListGeneratorImpl;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LottoTest {

    @Test
    public void 로또_3개_정답_테스트() {
        FixedListGeneratorImpl fixedListGenerator = new FixedListGeneratorImpl(0);
        Lotto myLotto = new Lotto(fixedListGenerator.getSixList());
        myLotto.isWinNumbers(Arrays.asList(1, 2, 4, 8, 3, 10));
        assertEquals(4, myLotto.getAnswer());
    }

    @Test
    public void 상금을_받는지_테스트() {
        FixedListGeneratorImpl fixedListGenerator = new FixedListGeneratorImpl(0);
        Lotto myLotto = new Lotto(fixedListGenerator.getSixList());
        assertTrue(myLotto.isWinNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void 로또번호_출력_테스트() {
        FixedListGeneratorImpl fixedListGenerator = new FixedListGeneratorImpl(0);
        Lotto myLotto = new Lotto(fixedListGenerator.getSixList());
        assertEquals("[1,2,3,4,5,6]",myLotto.convert());
    }
}