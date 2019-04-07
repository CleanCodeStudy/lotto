package domain;

import domain.vo.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private List<LottoNumber> winningNumbers;
    private LottoNumber bonusBall;

    public WinningNumbers(List<Integer> numbers, Integer bonusBall) {
        winningNumbers = convertLottoNumbers(numbers);
        this.bonusBall = LottoNumber.pickNumber(bonusBall);
    }

    private List<LottoNumber> convertLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::pickNumber)
                .collect(Collectors.toList());
    }

    public Rank confirm(LottoTicket lottoTicket) {
        long correctAmount = matchNumber(lottoTicket);
        boolean correctBonusBall = lottoTicket.hasNumber(bonusBall);

        return Rank.valueOf(correctBonusBall,correctAmount);
    }

    private long matchNumber(LottoTicket lottoTicket) {
        return winningNumbers.stream()
                .filter(lottoTicket::hasNumber)
                .count();
    }
}
