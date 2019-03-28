package com.ccstudy.lotto.controller;

import com.ccstudy.lotto.domain.Lotto;
import com.ccstudy.lotto.domain.LottoGame;
import com.ccstudy.lotto.domain.LottoResult;
import com.ccstudy.lotto.domain.WinningNumber;
import com.ccstudy.lotto.util.RandomGeneratorImpl;
import com.ccstudy.lotto.view.Input;
import com.ccstudy.lotto.view.Output;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        Input input = new Input(System.in);

        int purchase = input.inputPurchase();

        int manualAmountOfLotto = input.inputManualAmountOfLotto();

        List<Lotto> manualLottos = input.inputManualLottoNumber(manualAmountOfLotto);

        LottoGame lottoGame = new LottoGame(purchase, manualLottos, new RandomGeneratorImpl());

        Output.printPurchaseLottos(lottoGame.getLottos());

        List<Integer> correctAnswer = input.inputCorrectAnswer();

        int bonusNumber = input.inputBonusNumber();

        WinningNumber winningNumber = new WinningNumber(correctAnswer, bonusNumber);

        LottoResult lottoResult = lottoGame.gameStart(winningNumber);

        Output.printWinningStatistics(lottoResult);

        Output.printYield(lottoResult);
    }
}
