package com.javabom.lotto;

import com.javabom.lotto.domain.LottoBill;
import com.javabom.lotto.domain.LottoMachine;
import com.javabom.lotto.domain.LottoResult;
import com.javabom.lotto.domain.ticket.LottoWinningTicket;
import com.javabom.lotto.domain.vo.LottoMoney;
import com.javabom.lotto.view.InputView;
import com.javabom.lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        int numberOfManualTicket = InputView.inputNumberOfManualTicket();

        LottoMoney lottoMoney = new LottoMoney(purchaseAmount, numberOfManualTicket);


        LottoBill lottoBill = LottoMachine.purchaseLottoTicket(lottoMoney);

        OutputView.printNumberOfTicket(lottoMoney);
        OutputView.printLottoTickets(lottoBill.getAllTickets());

        List<Integer> winningNumbers = InputView.inputLastWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();

        LottoWinningTicket lottoWinningTicket = new LottoWinningTicket(winningNumbers, bonusNumber);

        LottoResult lottoResult = lottoBill.drawAllLotto(lottoWinningTicket);

        OutputView.printWinningStatistics(lottoResult, lottoMoney);
    }
}
