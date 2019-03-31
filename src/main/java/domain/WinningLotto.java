package domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private List<LottoNo> winningLottoNumbers;
    private LottoNo bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.winningLottoNumbers = numbers.stream()
                .map(integer -> new LottoNo(integer))
                .collect(Collectors.toList());
        this.bonusNumber = new LottoNo(bonusNumber);
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
