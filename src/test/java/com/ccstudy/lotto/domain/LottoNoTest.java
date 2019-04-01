package com.ccstudy.lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoNoTest {

    @Test
    public void 숫자_1_만들기() {
        LottoNo lottoNo = new LottoNo(1);

        assertThat(lottoNo.getNumber()).isEqualTo(1);
    }

    @Test(expected = RuntimeException.class)
    public void 숫자_1_에서_45_사이_아닐시_RuntimeException_발생() {
        LottoNo lottoNo = new LottoNo(46);
        LottoNo lottoNo1 = new LottoNo(0);
    }
}