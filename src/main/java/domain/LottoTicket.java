package domain;

import domain.prize.PrizeGroup;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int DEFAULT_PRICE = 1000;

    private List<LottoNo> lottoNumbers;

    public LottoTicket(List<Integer> numbers) {
        this.lottoNumbers = makeLottoNos(numbers);
    }

    public List<Integer> getNumbers() {
        return lottoNumbers.stream()
                .map(LottoNo::getNumber)
                .collect(Collectors.toList());
    }

    public String getListString() {
        return getNumbers().toString();
    }

    public boolean checkRank(int match, List<Integer> winningNumbers) {
        return match == getCountOfMatch(winningNumbers);
    }

    public int getCountOfMatch(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(winningNumber -> hasNumber(winningNumber))
                .count();
    }

    public boolean hasNumber(int winningNumber) {
        return getNumbers().contains(winningNumber);
    }

    public boolean isThirdRank(WinningLotto winningLotto) {
        return (!hasBonus(winningLotto)) && hasCountOfSecondRank(winningLotto);
    }

    public boolean hasBonus(WinningLotto winningLotto) {
        return this.getNumbers()
                .contains(winningLotto.getBonusNumber());
    }

    public boolean hasCountOfSecondRank(WinningLotto winningLotto) {
        return getCountOfMatch(winningLotto.getWinningLottoNumbers()) == PrizeGroup.SECOND.getCountOfMatch();
    }

    private List<LottoNo> makeLottoNos(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> new LottoNo(number))
                .collect(Collectors.toList());
    }
}
