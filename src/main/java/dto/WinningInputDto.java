package dto;

import domain.LottoNo;
import domain.WinningLotto;
import util.StringConverter;

import java.util.List;
import java.util.stream.Collectors;

public class WinningInputDto {
    private List<Integer> winningNumbers;
    private int bonus;

    public WinningInputDto(String winningNumbers, String bonus) {
        this.winningNumbers = StringConverter.stringToIntegerList(winningNumbers);
        this.bonus = Integer.valueOf(bonus);
        validate();
    }

    private void validate() {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException("숫자 중복");
        }
    }

    public WinningLotto toWinningLotto() {
        List<LottoNo> winningNumber = this.winningNumbers.stream()
                .map(integer -> new LottoNo(integer))
                .collect(Collectors.toList());
        LottoNo bonus = new LottoNo(this.bonus);
        return new WinningLotto(winningNumber, bonus);
    }
}
