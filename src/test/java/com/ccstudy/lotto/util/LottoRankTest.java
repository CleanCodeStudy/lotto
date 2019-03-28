package com.ccstudy.lotto.util;

import com.ccstudy.lotto.domain.Lotto;
import com.ccstudy.lotto.domain.WinningNumber;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {
    @Test
    public void 번호5개와_보너스번호_맞췄을때_SECOND_반환() {
        //NumberGenerator 변경하고 나서 로또 생성부분도 변경해야함
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 7), 6);

        assertThat(LottoRank.getRank(lotto, winningNumber)).isEqualTo(LottoRank.SECOND);
    }
}