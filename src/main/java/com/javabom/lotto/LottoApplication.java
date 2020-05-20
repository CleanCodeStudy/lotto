package com.javabom.lotto;

import com.javabom.lotto.domain.ticket.LottoTicketDispenser;
import com.javabom.lotto.domain.ticket.RandomLottoNumberGenerator;
import com.javabom.lotto.view.InputView;
import com.javabom.lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        int ticketQuantity = InputView.getBuyTicketQuantity();

        LottoTicketDispenser lottoTicketDispenser = new LottoTicketDispenser(new RandomLottoNumberGenerator());

        OutputView.printLottoTickets(lottoTicketDispenser.getAutoTickets(ticketQuantity));
    }
}
