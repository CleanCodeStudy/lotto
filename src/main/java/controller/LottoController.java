package controller;

import domain.LottoMachine.LottoMachine;
import domain.WinningLotto;
import domain.bundle.LottoBundle;
import dto.BuyLottoTicketDto;
import dto.InputDto;
import dto.LottoResultDto;
import dto.WinningInputDto;
import view.InputView;
import view.OutputView;

public class LottoController {

    private static InputView inputView = new InputView(System.in);
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        InputDto inputDto = inputView.getPriceAndManual();

        LottoMachine lottoMachine = new LottoMachine(inputDto);

        BuyLottoTicketDto buyLottoTicketDto = lottoMachine.buyLotto();

        LottoBundle lottoBundle = new LottoBundle(buyLottoTicketDto);

        outputView.getBuyList(lottoBundle);

        WinningInputDto winningInputDto = inputView.getWinInputDto();

        WinningLotto winningLotto = new WinningLotto(winningInputDto);

        LottoResultDto lottoResultDto = new LottoResultDto(lottoBundle, winningLotto);

        outputView.getStatistics(lottoResultDto);
    }

}
