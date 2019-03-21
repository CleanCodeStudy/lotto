package view;

import domain.RandomLottoList;
import dto.LottoResultDto;

public class ResultView {

    public void showBuyedList(RandomLottoList randomLottoList) {
        randomLottoList.showList();
    }

    public String getStats(LottoResultDto lottoResultDto) {
        return lottoResultDto.getResult();
    }
}
