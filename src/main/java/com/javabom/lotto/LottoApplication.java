package com.javabom.lotto;

import com.javabom.lotto.domain.*;
import com.javabom.lotto.view.InputView;
import com.javabom.lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        LottoInfo lottoInfo = new LottoInfo(InputView.askInputMoney());
        LottoNumbers lottoNumbers = new LottoNumbers(lottoInfo.getGameMoney(), new LottoNumberShuffler());
        OutputView.printLottoNumbers(lottoNumbers.getNumbers());
        WinningNumber winningNumber = new WinningNumber(InputView.askWinningNumber(), InputView.askBonusNumber());
        WinningStatistics winningStatistics = new WinningStatistics(
                        lottoNumbers.findLottoRanks(winningNumber.getWinningNumber(),
                        winningNumber.getBonusNumber()));
        ProfitRatio profitRatio = winningStatistics.getProfitRatio(lottoInfo.getGameMoney());
        OutputView.printWinningStatistics(winningStatistics.findEachRankCount(), profitRatio.getRatio());

    }
}
