package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.dto.BonusNumberDto;
import com.javabom.lotto.domain.dto.WinningNumbersDto;
import com.javabom.lotto.domain.result.LottoRank;
import com.javabom.lotto.domain.result.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LottoTicketsTest {

    @Test
    @DisplayName("로또 당첨 결과 반환 테스트.")
    void getLottoResult() {
        LottoTickets lottoTickets = createLottoTickets();
        WinningNumbersDto winningNumbersDto = new WinningNumbersDto("1,2,3,4,5,6");
        BonusNumberDto bonusNumberDto = new BonusNumberDto("7");

        WinningTicket winningTicket = new WinningTicket(winningNumbersDto, bonusNumberDto);
        LottoResult lottoResult = lottoTickets.getLottoResult(winningTicket);
        List<LottoRank> lottoRanks = new ArrayList<>();
        lottoRanks.add(LottoRank.FIRST_PLACE);
        lottoRanks.add(LottoRank.SECOND_PLACE);

        assertEquals(lottoRanks, lottoResult.getResults());
    }

    LottoTickets createLottoTickets() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        Set<LottoNumber> lottoNumbers1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        LottoTicket lottoTicket1 = new LottoTicket(lottoNumbers1);

        Set<LottoNumber> lottoNumbers2 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7)).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

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