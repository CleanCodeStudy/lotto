package com.ccstudy.lotto.domain;

import com.ccstudy.lotto.view.InputDto;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    @Test
    public void 수동_2개_생성_테스트() {
        List<String> manualLottos = Arrays.asList("1,3,4,5,6,7", "13,14,15,16,18,20");
        InputDto inputDto = new InputDto(2000, 2, manualLottos);

        LottoGame lottoGame = new LottoGame(inputDto);

        assertThat(lottoGame.getLottoTickets().get(0).getLottoNumbers()).contains(1, 3, 4, 5, 6, 7);
        assertThat(lottoGame.getLottoTickets().get(1).getLottoNumbers()).contains(13, 14, 15, 16, 18, 20);
    }
}