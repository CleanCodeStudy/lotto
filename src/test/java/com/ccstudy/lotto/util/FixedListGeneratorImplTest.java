package com.ccstudy.lotto.util;

import com.ccstudy.lotto.domain.Lotto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FixedListGeneratorImplTest {


    @Test
    public void 고정된_6자리_리스트_생성() {
        FixedGeneratorImpl fixedListGenerator = new FixedGeneratorImpl(0);
        Lotto myLotto = new Lotto(fixedListGenerator.getSixList());

        assertThat(myLotto.getNumbers()).contains(1,2,3,4,5,6);
    }

    @Test
    public void 시작숫자에_따른_리스트_2개_생성() {
        FixedGeneratorImpl fixedListGenerator = new FixedGeneratorImpl(0);

        assertThat(fixedListGenerator.getSixList()).contains(1,2,3,4,5,6);
        assertThat(fixedListGenerator.getSixList()).contains(2,3,4,5,6,7);
    }
}