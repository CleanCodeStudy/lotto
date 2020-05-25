package com.javabom.lotto;

import com.javabom.lotto.domain.*;
import com.javabom.lotto.view.InputView;
import com.javabom.lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        int totalPrice = InputView.askTotalPrice();
        LottoStore lottoStore = new LottoStore(new AutoLottoTicketGenerator());
        LottoTickets lottoTickets = lottoStore.buyTickets(totalPrice);

        OutputView.printLottoTicketNumbers(lottoTickets);
        String winningNumbers = InputView.askLastWeekLottoNumber();

        LottoGameResult lottoGameResult = lottoStore.askLottoGameResult(lottoTickets, new WinningResult(winningNumbers));

        OutputView.printWinningResult(lottoGameResult, totalPrice);
    }
}
