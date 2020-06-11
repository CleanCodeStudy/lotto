package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.result.LottoRank;
import com.javabom.lotto.domain.result.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTicketsTest {

    @Test
    @DisplayName("로또 당첨 결과 반환 테스트.")
    void getLottoResult() {
        LottoTickets lottoTickets = createLottoTickets();
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumber bonusNumber = new LottoNumber(7);

        WinningTicket winningTicket = new WinningTicket(lottoNumbers, bonusNumber);
        LottoResult lottoResult = lottoTickets.getLottoResult(winningTicket);
        List<LottoRank> lottoRanks = new ArrayList<>();
        lottoRanks.add(LottoRank.FIRST_PLACE);
        lottoRanks.add(LottoRank.SECOND_PLACE);

        assertEquals(lottoRanks, lottoResult.getResults());
    }

    LottoTickets createLottoTickets() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        List<LottoNumber> lottoNumbers1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        LottoTicket lottoTicket1 = new LottoTicket(lottoNumbers1);

        List<LottoNumber> lottoNumbers2 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7))
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        LottoTicket lottoTicket2 = new LottoTicket(lottoNumbers2);
        lottoTickets.add(lottoTicket1);
        lottoTickets.add(lottoTicket2);
        return new LottoTickets(lottoTickets);
    }

    @Test
    void sizeTest() {
        LottoTickets lottoTickets = createLottoTickets();
        assertEquals(2, lottoTickets.size());
    }

    @Test
    @DisplayName("매개변수로 받은 티켓을 합쳐 반환하는지 확인.")
    public void joinTicketsTest() {
        LottoTickets lottoTickets1 = createLottoTickets();
        LottoTickets lottoTickets2 = createLottoTickets();
        LottoTickets joinTickets = lottoTickets1.joinTickets(lottoTickets2);

        assertEquals(4, joinTickets.size());
    }
}