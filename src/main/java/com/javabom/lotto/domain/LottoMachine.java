package com.javabom.lotto.domain;

import com.javabom.lotto.domain.dto.ManualNumbersDto;
import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.vo.LottoMoney;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private LottoMachine() {
    }

    public static LottoBill purchaseLottoTicket(List<ManualNumbersDto> manualNumbersDtos, int numberOfAutoTicket) {
        List<LottoTicket> lottoTickets = manualNumbersDtos.stream()
                .map(manualNumbersDto -> LottoTicket.ofFixed(manualNumbersDto.getManualNumbers()))
                .collect(Collectors.toList());

        for (int i = 0; i < numberOfAutoTicket; i++) {
            lottoTickets.add(LottoTicket.ofAuto());
        }

        return new LottoBill(lottoTickets);
    }
}
