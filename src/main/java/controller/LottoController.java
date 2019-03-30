package controller;

import model.LottoGame;
import model.LottoMachine;
import model.LottoTicket;
import model.LottoYield;
import util.RandomListGeneratorImpl;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.startLotto();
    }

    public void startLotto() {
        InputView inputView = new InputView(System.in);

        int myPurchasePrice = inputView.purchase();
        int manualLottoCount = inputView.getManualCount();
        List<LottoTicket> manualLottos = inputView.inputManualLotto(manualLottoCount);

        LottoMachine lottoMachine = new LottoMachine(myPurchasePrice, manualLottos, new RandomListGeneratorImpl());
        OutputView.viewLottoTicketsNum(lottoMachine);

        List<Integer> winNumbers = inputView.inputWinNumber();

        LottoGame lottoGame = new LottoGame(winNumbers, lottoMachine);
        LottoYield lottoResult = new LottoYield(lottoGame, myPurchasePrice);

        OutputView.viewLottoAnalyze(lottoResult);
    }

}
