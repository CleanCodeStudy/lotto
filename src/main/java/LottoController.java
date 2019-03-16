import domain.PurchasedLottos;
import domain.result.WinningResult;
import util.RandomNumberGenerator;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        int buyPrice = InputView.purchaseLotto(System.in);

        PurchasedLottos purchasedLottos = new PurchasedLottos(buyPrice, new RandomNumberGenerator());
        ResultView.printMyLottos(purchasedLottos);

        List<String> winningNumbers = InputView.inputWinningNumber(System.in);
        WinningResult winningResult = purchasedLottos.confirmLottos(purchasedLottos, winningNumbers);
        ResultView.printResults(winningResult);
    }
}
