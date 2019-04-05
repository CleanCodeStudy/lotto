package com.ccstudy.lotto.controller;

import com.ccstudy.lotto.domain.LottoTicket;
import com.ccstudy.lotto.domain.LottoGame;
import com.ccstudy.lotto.domain.LottoResult;
import com.ccstudy.lotto.domain.WinningNumber;
import com.ccstudy.lotto.view.Input;
import com.ccstudy.lotto.view.InputDto;
import com.ccstudy.lotto.view.Output;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        Input input = new Input(System.in);

        InputDto inputDto = input.purchaseLottos();

        LottoGame lottoGame = new LottoGame(inputDto);

        Output.printPurchaseLottos(inputDto, lottoGame.getLottoTickets());

        WinningNumber winningNumber = input.inputWinningNumber();

        LottoResult lottoResult = lottoGame.gameStart(winningNumber);

        Output.printWinningStatistics(lottoResult);

        Output.printYield(lottoResult);
    }
}
