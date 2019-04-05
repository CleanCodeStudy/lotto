package domain;

import dto.WinningInputDto;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private List<LottoNo> winningLottoNumbers;
    private LottoNo bonusNumber;

    public WinningLotto(WinningInputDto winningInputDto) {
        this.winningLottoNumbers = winningInputDto.getWinningNumbers().stream()
                .map(integer -> new LottoNo(integer))
                .collect(Collectors.toList());
        this.bonusNumber = new LottoNo(winningInputDto.getBonus());
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
