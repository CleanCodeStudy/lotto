package com.ccstudy.lotto.domain;

import com.ccstudy.lotto.util.LottoRank;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class WinningNumberTest {
    @Test
    public void 로또_5개_맞췄을때_5_반환() {
        LottoTicket lottoTicket = createLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 7), 6);

        assertThat(winningNumber.getAnswerCount(lottoTicket)).isEqualTo(5);
    }

    @Test
    public void 보너스번호_맞추면_true_반환() {
        LottoTicket lottoTicket = createLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 7), 6);

        assertThat(winningNumber.isCorrectBonus(lottoTicket)).isEqualTo(true);
    }

    public LottoTicket createLottoTicket(List<Integer> numbers) {
        List<LottoNo> lottoNos = numbers.stream()
                .map(integer -> new LottoNo(integer))
                .collect(Collectors.toList());
        return new LottoTicket(lottoNos);
    }
}