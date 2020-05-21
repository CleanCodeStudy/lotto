package com.javabom.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoTicketGeneratorTest {

    @DisplayName("6개의 숫자를 가지는 랜덤로또티켓을 반환한다")
    @Test
    void random() {
        LottoTicket lottoTicket = AutoLottoTicketGenerator.generate();

        assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
    }
}
