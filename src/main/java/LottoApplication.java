import domain.LottoGame;
import dto.PurchaseInfoDto;
import dto.WinningNumberDto;
import dto.WinningResultDto;
import view.InputView;
import view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        PurchaseInfoDto purchaseInfo = InputView.enterPurchaseInfo(System.in);
        LottoGame lottoGame = purchaseInfo.buyLotto();

        ResultView.printMyLottos(lottoGame.getLottoTickets());

        WinningNumberDto winningNumberDto = InputView.inputWinningNumber(System.in);

        WinningResultDto winningResultDto = lottoGame.confirmLottos(winningNumberDto);

        ResultView.printResults(winningResultDto);
    }
}
