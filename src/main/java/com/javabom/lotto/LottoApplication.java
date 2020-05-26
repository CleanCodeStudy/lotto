package com.javabom.lotto;

import com.javabom.lotto.domain.DrawingMachine;
import com.javabom.lotto.domain.LottoMachine;
import com.javabom.lotto.domain.LottoResult;
import com.javabom.lotto.domain.LottoTicket;
import com.javabom.lotto.domain.vo.LottoMoney;
import com.javabom.lotto.view.InputView;
import com.javabom.lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        LottoMoney lottoMoney = InputView.inputPurchaseAmount();

        OutputView.printNumberOfTicket(lottoMoney);

        List<LottoTicket> lottoTickets = LottoMachine.purchaseLottoTicket(lottoMoney);

        OutputView.printLottoTickets(lottoTickets);

        List<Integer> winningNumbers = InputView.inputLastWinningNumbers();

        DrawingMachine drawingMachine = new DrawingMachine(winningNumbers);

        LottoResult lottoResult = new LottoResult(lottoMoney, drawingMachine.drawAllLottoTicket(lottoTickets));

        OutputView.printWinningStatistics(lottoResult);
    }
}
