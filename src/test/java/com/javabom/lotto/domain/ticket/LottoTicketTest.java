package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.dto.BonusNumberDto;
import com.javabom.lotto.domain.dto.WinningNumbersDto;
import com.javabom.lotto.domain.result.LottoRank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTicketTest {

    @Test
    void findLottoRankTest() {
        WinningNumbersDto winningNumbersDto = new WinningNumbersDto("1,2,3,4,5,6");
        BonusNumberDto bonusNumberDto = new BonusNumberDto("11");
        WinningTicket winningTicket = new WinningTicket(winningNumbersDto, bonusNumberDto);
        Set<LottoNumber> lottoNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        assertEquals(LottoRank.FIRST_PLACE, lottoTicket.findLottoRank(winningTicket));
    }
}