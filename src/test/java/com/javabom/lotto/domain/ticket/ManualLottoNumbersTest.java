package com.javabom.lotto.domain.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoNumbersTest {

    @DisplayName("수동 입력 정수가 로또티켓으로 변환되는지 확인")
    @Test
    void toLottoTicket() {
        // given
        ManualLottoNumbers manualLottoNumbers = new ManualLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket expectedLottoTicket = new LottoTicket(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));

        // then
        assertThat(manualLottoNumbers.toLottoTicket()).isEqualTo(expectedLottoTicket);
    }
}