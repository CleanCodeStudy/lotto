package com.javabom.lotto;

import com.javabom.lotto.domain.compare.LottoLuckyNumbers;
import com.javabom.lotto.domain.compare.LottoResults;
import com.javabom.lotto.domain.compare.LottoTicketComparator;
import com.javabom.lotto.domain.ticket.LottoTicketDispenser;
import com.javabom.lotto.domain.ticket.LottoTickets;
import com.javabom.lotto.domain.ticket.RandomLottoNumberGenerator;
import com.javabom.lotto.view.InputView;
import com.javabom.lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        long inputMoney = InputView.getMoneyToBuyTicket();
        int ticketQuantity = (int) inputMoney / 1000;

        LottoTicketDispenser lottoTicketDispenser = new LottoTicketDispenser(new RandomLottoNumberGenerator());
        LottoTickets lottoTickets = lottoTicketDispenser.getAutoTickets(ticketQuantity);
        OutputView.printLottoTickets(lottoTickets);

        LottoLuckyNumbers luckyNumbers = InputView.getLottoLuckyNumbers();

        LottoTicketComparator lottoTicketComparator = new LottoTicketComparator(luckyNumbers);
        LottoResults lottoResults = lottoTicketComparator.getLottoResults(lottoTickets);
        OutputView.printLottoResults(lottoResults);
        OutputView.printEarningRate(inputMoney, lottoResults.getTotalPrizeMoney());
    }
}
