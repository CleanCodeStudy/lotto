package com.ccstudy.lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LottoTicketTest {

    @Test
    public void 로또_4개_정답_테스트() {
        LottoTicket myLottoTicket = LottoMachine.createFixedLottoTicket(1).get(0);
        assertEquals(4, myLottoTicket.getAnswer(Arrays.asList(1, 2, 4, 8, 3, 10)));
    }
}