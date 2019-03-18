package view;

import domain.LottoList;
import dto.LottoResultDto;

public class ResultView {

    public void showBuyedList(LottoList lottoList) {
        lottoList.showList();
    }

    public String getStats(LottoResultDto lottoResultDto) {
        return lottoResultDto.getResult();
    }
}
