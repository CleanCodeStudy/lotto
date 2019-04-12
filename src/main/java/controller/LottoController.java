package controller;

import data.PurchaseInfo;
import data.WinnigNumber;
import model.LottoMachine;
import model.LottoResult;
import view.InputView;
import view.OutputView;

public class LottoController {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.startLotto();
    }

    public void startLotto() {
        InputView inputView = new InputView(System.in);

        PurchaseInfo purchaseInfo = new PurchaseInfo(inputView);

        LottoMachine lottoMachine = new LottoMachine(purchaseInfo);

        OutputView.viewLottoTicketsNum(purchaseInfo, lottoMachine);

        WinnigNumber winnigNumber = new WinnigNumber(inputView);

        LottoResult lottoResult = new LottoResult(lottoMachine, winnigNumber);

        OutputView.viewLottoAnalyze(lottoResult, purchaseInfo);
    }

}
