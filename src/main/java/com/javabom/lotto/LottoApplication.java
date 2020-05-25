package com.javabom.lotto;

import com.javabom.lotto.domain.*;
import com.javabom.lotto.domain.lottery.*;
import com.javabom.lotto.domain.shop.LottoNumberShuffler;
import com.javabom.lotto.view.InputView;
import com.javabom.lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int gameMoney = new LottoInformation(InputView.askInputMoney()).getGameMoney();
        LottoNumbersList lottoNumbersList = new LottoNumbersList(gameMoney, new LottoNumberShuffler());
        OutputView.printLottoNumbers(lottoNumbersList);
        List<LottoRank> lottoRanks = lottoNumbersList.findLottoRanks(new WinningNumbers(InputView.askWinningNumber()), new BonusNumber(InputView.askBonusNumber()));
        WinningStatistics winningStatistics = new WinningStatistics(lottoRanks);
        OutputView.printWinningStatistics(winningStatistics, gameMoney);
    }
}
