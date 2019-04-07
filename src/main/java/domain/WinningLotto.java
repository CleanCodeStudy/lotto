package domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private List<LottoNo> winningLottoNumbers;
    private LottoNo bonusNumber;

    public WinningLotto(List<LottoNo> lottoNos, LottoNo bonus) {
        this.winningLottoNumbers = lottoNos;
        this.bonusNumber = bonus;
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers.stream()
                .map(LottoNo::getNumber)
                .collect(Collectors.toList());
    }

    public Integer getBonusNumber() {
        return bonusNumber.getNumber();
    }

}
