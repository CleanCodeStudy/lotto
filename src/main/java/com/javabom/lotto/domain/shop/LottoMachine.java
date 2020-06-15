package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.number.OrderGameNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final LottoNumbersGenerator lottoNumbersGenerator;

    public LottoMachine(LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    public List<LottoTicket> createManualLottoTicket(List<List<OrderGameNumber>> manualLottoNumbers) {
        List<LottoTicket> manualLottoTickets = new ArrayList<>();
        for (List<OrderGameNumber> manualLottoNumber : manualLottoNumbers) {
            LottoTicket manualLottoTicket = new LottoTicket(manualLottoNumber);
            manualLottoTickets.add(manualLottoTicket);
        }
        return manualLottoTickets;
    }

    public List<LottoTicket> createAutoLottoTicket(int autoLottoTicketCount) {
        List<LottoTicket> autoLottoTickets = new ArrayList<>();
        for (int count = 1; count <= autoLottoTicketCount; count++) {
            LottoTicket autoLottoTicket = new LottoTicket(lottoNumbersGenerator.generate());
            autoLottoTickets.add(autoLottoTicket);
        }
        return autoLottoTickets;
    }
}
