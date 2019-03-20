package com.ccstudy.lotto.controller;

import com.ccstudy.lotto.domain.LottoGame;
import com.ccstudy.lotto.domain.LottoResult;
import com.ccstudy.lotto.util.RandomListGeneratorImpl;
import com.ccstudy.lotto.view.Input;
import com.ccstudy.lotto.view.Output;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        Input input = new Input(System.in);

        int purchase = input.inputPurchase();

        LottoGame lottoGame = new LottoGame(purchase,new RandomListGeneratorImpl());

        Output.printPurchaseLottos(lottoGame.getLottos());

        List<Integer> correctAnswer = input.inputCorrectAnswer();

        LottoResult lottoResult = lottoGame.gameStart(correctAnswer);

        Output.printWinningStatistics(lottoResult);

        Output.printYield(lottoResult);
    }
}
