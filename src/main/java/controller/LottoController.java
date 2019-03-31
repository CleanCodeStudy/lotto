package controller;

import domain.LottoMachine.LottoMachine;
import domain.LottoMachine.ManualLottoMachine;
import domain.LottoMachine.RandomLottoMachine;
import domain.LottoTicket;
import domain.WinningLotto;
import domain.bundle.LottoBundle;
import dto.InputDto;
import dto.LottoResultDto;
import dto.ManualNumberDto;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);
        OutputView outputView = new OutputView();

        int price = inputView.getPrice();
        int manualAmount = inputView.getManualAmount();
        List<ManualNumberDto> manualNumbers = inputView.getManualLottoNumbers(manualAmount);

        InputDto inputDto = new InputDto(price, manualAmount, manualNumbers);

        LottoMachine manualLottoMachine = new ManualLottoMachine(inputDto);
        LottoMachine randomLottoMachine = new RandomLottoMachine(inputDto);
        List<LottoTicket> manualLottoTickets = manualLottoMachine.buyLotto();
        List<LottoTicket> randomLottoTickets = randomLottoMachine.buyLotto();

        LottoBundle lottoBundle = new LottoBundle(manualLottoTickets, randomLottoTickets);

        System.out.println(outputView.showBuyedList(lottoBundle));

        List<Integer> winningNumbers = inputView.getWinningNumbers();
        int bonus = inputView.getBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);

        LottoResultDto lottoResultDto = new LottoResultDto(lottoBundle, winningLotto);
        System.out.println(new OutputView().getStatistics(lottoResultDto));
    }

}
