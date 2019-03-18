package controller;

import model.Lotto;
import model.LottoGame;
import model.LottoResult;
import util.RandomListGeneratorImpl;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.startLotto();
    }

    public void startLotto() {
        InputView inputView = new InputView(System.in);

        int myPurchasePrice = inputView.purchase();
        int lottoCount = myPurchasePrice / LOTTO_PRICE;

        List<Lotto> myLottos = makePurchaseLottoList(lottoCount);

        OutputView.viewRandomNum(myLottos);

        List<Integer> correctAnswer = inputView.winNumber();

        LottoGame lottoGame = new LottoGame(myLottos, correctAnswer);
        LottoResult lottoResult = new LottoResult(lottoGame.makeResult(), myPurchasePrice);

        OutputView.viewLottoAnalyze(lottoResult);
    }

    private List<Lotto> makePurchaseLottoList(int purchaseCount) {
        List<Lotto> purchaseLottos = new ArrayList<>();
        RandomListGeneratorImpl randomListGenerator = new RandomListGeneratorImpl();

        for (int i = 0; i < purchaseCount; i++) {
            Lotto myLotto = new Lotto(randomListGenerator.getSixList());
            purchaseLottos.add(myLotto);
        }
        return purchaseLottos;
    }

}
