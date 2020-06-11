package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.dto.WinningNumbersDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WinningTicketTest {

    @Test
    @DisplayName("당첨번호에 보너스 번호 중복된 번호가 존재시 예외처리.")
    void validDuplicatedTest() {
        List<LottoNumber> winningNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumber bonusNumber = new LottoNumber(5);
        assertThatThrownBy(() -> new WinningTicket(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨번호에 보너스 번호가 중복된 번호가 존재합니다.");
    }

    @Test
    void containsTest() {
        List<LottoNumber> winningNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningTicket winningTicket = new WinningTicket(winningNumbers, bonusNumber);
        LottoNumber lottoNumber = new LottoNumber(5);
        assertTrue(winningTicket.contains(lottoNumber));
    }

    @Test
    void isSameBonusNumber() {
        List<LottoNumber> winningNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningTicket winningTicket = new WinningTicket(winningNumbers, bonusNumber);
        LottoNumber lottoNumber = new LottoNumber(11);
        assertTrue(winningTicket.isSameBonusNumber(lottoNumber));
    }
}