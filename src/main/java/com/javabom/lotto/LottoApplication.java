package com.javabom.lotto;

import com.javabom.lotto.domain.shop.LottoShop;
import com.javabom.lotto.domain.shop.RandomMachine;
import com.javabom.lotto.domain.shop.ShuffleLottoNumber;
import com.javabom.lotto.domain.info.LottoBundle;
import com.javabom.lotto.domain.info.PrizeNumberInfo;
import com.javabom.lotto.domain.result.LottoResultBundle;
import com.javabom.lotto.domain.vo.Money;
import com.javabom.lotto.view.InputView;
import com.javabom.lotto.view.OutputView;

import java.util.Scanner;

public class LottoApplication {
    private static final InputView inputView = new InputView(new Scanner(System.in));

    public static void main(String[] args) {
        Money money = new Money(inputView.inputMoney());

        LottoShop lottoShop = new LottoShop(new RandomMachine(new ShuffleLottoNumber()));
        LottoBundle lottoBundle = lottoShop.buyLotto(money);

        OutputView.printLottoCount(lottoShop.getLottoCount(money.get()));
        OutputView.printMyLottoBundle(lottoBundle);

        PrizeNumberInfo prizeNumberInfo = new PrizeNumberInfo(
                inputView.inputPrizeNumbers(), inputView.inputBonusNumber());

        LottoResultBundle lottoResultBundle = lottoBundle.confirmLottoResult(prizeNumberInfo);

        OutputView.printResults(lottoResultBundle, money);
    }
}
