package domain.result;

import domain.Lotto;

import java.util.List;

public class LottoResult {
    private Lotto myLotto;
    private int correctAmount;

    public LottoResult(Lotto myLotto, List<Integer> winningNumbers) {
        this.myLotto = myLotto;
        confirmLotto(winningNumbers);
    }

    private void confirmLotto(List<Integer> winnigNumbers) {
        for (Integer winningNumber : winnigNumbers) {
            confirmNumber(winningNumber);
        }
    }

    private void confirmNumber(int winnginNumber) {
        if (myLotto.hasNumber(winnginNumber)) {
            correctAmount++;
        }
    }

    public boolean isEqualToAmount(int winningAmount) {
        return this.correctAmount == winningAmount;
    }
}
