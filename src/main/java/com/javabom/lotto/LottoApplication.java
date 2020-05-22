package com.javabom.lotto;

import com.javabom.lotto.domain.*;
import com.javabom.lotto.util.LottoFactory;
import com.javabom.lotto.util.ShuffleLottoNumbers;
import com.javabom.lotto.view.InputView;
import com.javabom.lotto.view.OutputView;

import java.util.Scanner;

public class LottoApplication {
    private static final InputView inputView = new InputView(new Scanner(System.in));

    public static void main(String[] args) {
        Money money = new Money(inputView.inputMoney());
        OutputView.printLottoCount(money.getLottoCount());

        MyLottoBundle myLottoBundle = new MyLottoBundle(
                LottoFactory.createLotto(money.getLottoCount(), new ShuffleLottoNumbers()));
        OutputView.printMyLottoBundle(myLottoBundle);

        PrizeNumbers prizeNumbers = new PrizeNumbers(inputView.inputPrizeNumbers());
        BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber(), prizeNumbers);

        MatchedCounts matchedCounts = new MatchedCounts(myLottoBundle.getMatchedCounts(prizeNumbers, bonusNumber));

        PrizeCounts prizeCounts = new PrizeCounts();
        prizeCounts.compileStatisticsOfPrize(matchedCounts);

        PrizeMoneys prizeMoneys = new PrizeMoneys(prizeCounts.getPrizeMoneys());

        OutputView.printResult(prizeCounts, money.getRateOfProfit(prizeMoneys.getAmountOfPrize()));
    }
}
