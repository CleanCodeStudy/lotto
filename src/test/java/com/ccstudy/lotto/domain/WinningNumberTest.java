package com.ccstudy.lotto.domain;

import com.ccstudy.lotto.util.LottoRank;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class WinningNumberTest {
    @Test
    public void 로또_5개와_보너스번호_맞췄을때_enum_class_SECOND_반환() {
        //NumberGenerator 변경하고 나서 로또 생성부분도 변경해야함
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 7), 6);

        assertThat(LottoRank.getRank(lotto, winningNumber)).isEqualTo(LottoRank.valueOf("SECOND"));
    }

    @Test
    public void 로또_5개_맞췄을때_5_반환() {
        //NumberGenerator 변경하고 나서 로또 생성부분도 변경해야함
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 7), 6);

        assertThat(winningNumber.getAnswerCount(lotto)).isEqualTo(5);
    }

    @Test
    public void 보너스번호_맞추면_true_반환() {
        //NumberGenerator 변경하고 나서 로또 생성부분도 변경해야함
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 7), 6);

        assertThat(winningNumber.isCorrectBonus(lotto)).isEqualTo(true);
    }
}