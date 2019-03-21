package controller;

import domain.LottoList;
import dto.LottoResultDto;
import view.ResultView;

import java.util.List;

public class LottoController {

    public String lotto(LottoList lottoList, List<Integer> winningNumbers) {

        LottoResultDto lottoResultDto = new LottoResultDto(lottoList, winningNumbers);

        return new ResultView().getStats(lottoResultDto);
    }
}
