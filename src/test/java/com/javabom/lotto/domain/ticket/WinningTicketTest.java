package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.dto.BonusNumberDto;
import com.javabom.lotto.domain.dto.WinningTicketDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WinningTicketTest {

    @Test
    void contains() {
        WinningTicketDto winningTicketDto = new WinningTicketDto("1,2,3,4,5,6");
        BonusNumberDto bonusNumberDto = new BonusNumberDto("11");
        WinningTicket winningTicket = new WinningTicket(winningTicketDto, bonusNumberDto);
        LottoNumber lottoNumber = new LottoNumber(5);
        assertTrue(winningTicket.contains(lottoNumber));
    }

    @Test
    void isSameBonusNumber() {
        WinningTicketDto winningTicketDto = new WinningTicketDto("1,2,3,4,5,6");
        BonusNumberDto bonusNumberDto = new BonusNumberDto("11");
        WinningTicket winningTicket = new WinningTicket(winningTicketDto, bonusNumberDto);
        LottoNumber lottoNumber = new LottoNumber(11);
        assertTrue(winningTicket.isSameBonusNumber(lottoNumber));
    }
}