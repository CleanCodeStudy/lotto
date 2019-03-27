package domain;

import util.numberGenerator.FixedNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private List<LottoNo> winningLottoNumbers;
    private LottoNo bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {

        this.winningLottoNumbers = new FixedNumberGenerator(numbers).createLottoNumbers();
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
