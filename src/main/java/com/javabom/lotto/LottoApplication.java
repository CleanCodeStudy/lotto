package com.javabom.lotto;

import com.javabom.lotto.domain.AutoLottoNumberGenerator;
import com.javabom.lotto.domain.LottoStore;
import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoTickets;
import com.javabom.lotto.view.InputView;
import com.javabom.lotto.view.OutputView;
import com.javabom.lotto.vo.Money;

public class LottoApplication {

    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore(new AutoLottoNumberGenerator());

        Money totalMoney = new Money(InputView.askTotalMoney());
        LottoTickets lottoTickets = lottoStore.buy(totalMoney);

        OutputView.printLottoTicketNumbers(lottoTickets);

        LottoTicket winningLottoTicket = new LottoTicket(InputView.askLastWeekWinningNumbers());
        LottoResult lottoResult = lottoTickets.getLottoResult(winningLottoTicket);

        OutputView.printResult(lottoResult, totalMoney);
    }
}
