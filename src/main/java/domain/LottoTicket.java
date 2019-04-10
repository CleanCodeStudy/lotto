package domain;

import domain.prize.PrizeGroup;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int DEFAULT_PRICE = 1000;
    public static final boolean MANUAL = Boolean.FALSE;

    private List<LottoNo> lottoNumbers;
    private boolean isRandom;

    public LottoTicket(List<Integer> numbers) {
        this.lottoNumbers = makeLottoNos(numbers);
        this.isRandom = Boolean.TRUE;
    }

    public LottoTicket(List<Integer> numbers, boolean isRandom) {
        this.lottoNumbers = makeLottoNos(numbers);
        this.isRandom = isRandom;
    }

    public List<Integer> getNumbers() {
        return lottoNumbers.stream()
                .map(LottoNo::getNumber)
                .collect(Collectors.toList());
    }

    public boolean isRandom() {
        return this.isRandom;
    }

    private List<LottoNo> makeLottoNos(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNo::selectNumber)
                .collect(Collectors.toList());
    }

    public String getListString() {
        return getNumbers().toString();
    }

    public int getCountOfMatch(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(this::hasNumber)
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
}
