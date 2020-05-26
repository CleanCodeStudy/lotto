package com.javabom.lotto;

import com.javabom.lotto.domain.compare.LottoBasicLuckyNumbers;
import com.javabom.lotto.domain.compare.LottoLuckyNumbers;
import com.javabom.lotto.domain.compare.LottoResults;
import com.javabom.lotto.domain.compare.LottoTicketComparator;
import com.javabom.lotto.domain.ticket.*;
import com.javabom.lotto.view.InputView;
import com.javabom.lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        Money inputMoney = new Money(InputView.getMoneyToBuyTicket());

        LottoTicketDispenser lottoTicketDispenser = new LottoTicketDispenser(new RandomLottoNumberGenerator());
        LottoTickets lottoTickets = lottoTicketDispenser.getAutoTickets(inputMoney);
        OutputView.printLottoTickets(lottoTickets);

        LottoBasicLuckyNumbers basicLuckyNumbers = new LottoBasicLuckyNumbers(InputView.getLottoBasicLuckyNumbers());
        LottoNumber bonusNumber = new LottoNumber(InputView.getBonusNumber());
        LottoLuckyNumbers LuckyNumbers = new LottoLuckyNumbers(basicLuckyNumbers, bonusNumber);

        LottoTicketComparator lottoTicketComparator = new LottoTicketComparator(LuckyNumbers);
        LottoResults lottoResults = lottoTicketComparator.getLottoResults(lottoTickets);
        OutputView.printLottoResults(lottoResults);
        OutputView.printEarningRate(inputMoney, lottoResults.getTotalPrizeMoney());
    }
}
