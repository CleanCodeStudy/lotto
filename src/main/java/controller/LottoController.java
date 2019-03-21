package controller;

import domain.RandomLottoList;
import dto.LottoResultDto;
import view.ResultView;

import java.util.List;

public class LottoController {

    public String lotto(RandomLottoList randomLottoList, List<Integer> winningNumbers) {

        LottoResultDto lottoResultDto = new LottoResultDto(randomLottoList, winningNumbers);

        return new ResultView().getStats(lottoResultDto);
    }
}
