package dto;

import domain.Lotto;

import java.util.List;

public class LottoDto {
    private Lotto myLotto;
    private List<Integer> winningLotto;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public LottoDto(Lotto myLotto, List<Integer> winningNumbers) {
        this.myLotto = myLotto;
        this.winningLotto = winningNumbers;
        this.amount = findCorrectNumber();
    }

    private int findCorrectNumber() {
        winningLotto.retainAll(myLotto.getNumbers());
        return winningLotto.size();
    }



}
