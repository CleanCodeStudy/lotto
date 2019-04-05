package domain;

import util.PrizeGroup;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private List<LottoNo> lottoNumbers;

    public LottoTicket(List<LottoNo> lottoNos) {
        this.lottoNumbers = lottoNos;
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

    public boolean isSecondRank(WinningLotto winningLotto){
        return (!hasBonus(winningLotto))&&hasCountOfSecondRank(winningLotto);
    }

    public boolean hasBonus(WinningLotto winningLotto) {
        return this.getNumbers()
                .contains(winningLotto.getBonusNumber());
    }

    public boolean hasCountOfSecondRank(WinningLotto winningLotto) {
        return getCountOfMatch(winningLotto.getWinningLottoNumbers()) == PrizeGroup.SECOND.getCountOfMatch();
    }
}
