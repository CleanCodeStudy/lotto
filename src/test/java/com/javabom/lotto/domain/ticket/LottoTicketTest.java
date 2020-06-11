package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.result.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTicketTest {

    @Test
    @DisplayName("요구사항에 맞게 당첨 결과를 반환하는지 확인.(당첨로또의 번호 순서와 발급받은 티켓의 번호순서까지 완벽하게 일치할때 1개 일치)")
    void findLottoRankTest() {
        WinningTicket winningTicket = createWinningNumbers();

        List<LottoNumber> lottoNumbers1 = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        List<LottoNumber> lottoNumbers2 = Stream.of(1, 2, 3, 4, 6, 5)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        LottoTicket lottoTicket1 = new LottoTicket(lottoNumbers1);
        LottoTicket lottoTicket2 = new LottoTicket(lottoNumbers2);

        assertEquals(LottoRank.FIRST_PLACE, lottoTicket1.findLottoRank(winningTicket));
        assertEquals(LottoRank.FOURTH_PLACE, lottoTicket2.findLottoRank(winningTicket));
    }

    @ParameterizedTest
    @DisplayName("입력되는 로또번호가 6개가 아닐시 예외처리.")
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void validLottoCountTest(String numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 로또 번호 수가 6개가 아닙니다.");
    }

    @Test
    @DisplayName("입력되는 로또번호가 6개가 아닐시 예외처리.")
    void validDuplicatedTest() {
        List<LottoNumber> lottoNumbers = Arrays.stream("1,2,3,4,5,5".split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new LottoTicket(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호 중 중복된 번호가 존재합니다.");
    }

    private WinningTicket createWinningNumbers() {
        List<LottoNumber> winningNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumber bonusNumber = new LottoNumber(7);
        return new WinningTicket(winningNumbers, bonusNumber);
    }
}