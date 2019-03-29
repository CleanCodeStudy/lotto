package controller;

import domain.WinningLotto;
import domain.bundle.LottoBundle;
import dto.LottoResultDto;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);

        LottoBundle lottoBundle = inputView.getLottoBundle();

        List<Integer> winningNumbers = inputView.getWinningNumbers();

        int bonus = inputView.getBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);

        LottoResultDto lottoResultDto = new LottoResultDto(lottoBundle, winningLotto);

        System.out.println(new OutputView().getStatistics(lottoResultDto));
    }

}
