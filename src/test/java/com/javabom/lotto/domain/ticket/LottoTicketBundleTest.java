package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.number.PrizeNumbersBundle;
import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.result.LottoResultBundle;
import com.javabom.lotto.domain.utils.GameNumberConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketBundleTest {

    @DisplayName("알맞은 로또 결과를 반환하는지 확인한다.")
    @Test
    public void match() {
        LottoTicket lottoTicket1 = new LottoTicket(
                GameNumberConverter.convert(Arrays.asList("1", "2", "3", "4", "5", "6")));
        LottoTicket lottoTicket2 = new LottoTicket(
                GameNumberConverter.convert(Arrays.asList("1", "3", "5", "7", "9", "11")));

        List<LottoTicket> lottoTicketList = Arrays.asList(lottoTicket1, lottoTicket2);

        LottoTicketBundle lottoTicketBundle = new LottoTicketBundle(lottoTicketList);

        List<String> prizeNumbers = Arrays.asList("1", "2", "4", "7", "9", "11");
        PrizeNumbersBundle prizeNumberBundle = new PrizeNumbersBundle(prizeNumbers, "30");

        LottoResultBundle lottoResultBundle = lottoTicketBundle.match(prizeNumberBundle);
        assertThat(lottoResultBundle.valueOf(0)).isEqualTo(LottoResult.FAIL);
        assertThat(lottoResultBundle.valueOf(1)).isEqualTo(LottoResult.FOURTH);
    }
}