package com.ccstudy.lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    public void 총_획득금액_테스트(){
        List<LottoTicket> lottoTickets = getFixedLottos(3);
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(4, 5, 6, 7, 8, 9), 3);
        LottoResult lottoResult = new LottoResult(lottoTickets, winningNumber);

        assertThat(lottoResult.getReceivedAmount()).isEqualTo(30055000);
    }

    @Test
    public void 총_수익률_테스트(){
        List<LottoTicket> lottoTickets = getFixedLottos(3);
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(5, 6, 7, 8, 9, 10), 11);
        LottoResult lottoResult = new LottoResult(lottoTickets, winningNumber);

        assertThat(lottoResult.getYield()).isEqualTo(1833.33);
    }

    public List<LottoTicket> getFixedLottos(int amoutOfLotto) {
        return LottoMachine.createFixedLottoTicket(amoutOfLotto);
    }

}