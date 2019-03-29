package controller;

import model.LottoGame;
import model.LottoMachine;
import model.LottoYield;
import util.RandomListGeneratorImpl;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Random;

public class LottoController {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.startLotto();
    }

    public void startLotto() {
        InputView inputView = new InputView(System.in);

        int myPurchasePrice = inputView.purchase();

        RandomListGeneratorImpl randomListGenerator = new RandomListGeneratorImpl();
        LottoMachine lottoMachine= new LottoMachine(myPurchasePrice, randomListGenerator);

        OutputView.viewRandomNum(lottoMachine.getLottoTickets());

        List<Integer> winNumbers = inputView.inputWinNumber();

        LottoGame lottoGame = new LottoGame(winNumbers, lottoMachine);
        LottoYield lottoResult = new LottoYield(lottoGame, myPurchasePrice);

        OutputView.viewLottoAnalyze(lottoResult);
    }

}
