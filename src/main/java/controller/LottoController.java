package controller;

import domain.LottoList;
import dto.LottoResultDto;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoController {

    public String start(){
        InputView inputView = new InputView(System.in);
        LottoList lottoList = inputView.getLottoList();
        List<Integer> winningNumbers = inputView.getWinningNumbers();

        return lotto(lottoList,winningNumbers);
    }

    public String lotto(LottoList lottoList, List<Integer> winningNumbers) {

        LottoResultDto lottoResultDto = new LottoResultDto(lottoList, winningNumbers);

        return new ResultView().getStats(lottoResultDto);
    }
}
