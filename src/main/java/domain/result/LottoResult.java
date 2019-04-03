package domain.result;

import domain.LottoTicket;

import java.util.List;

public class LottoResult {
    private LottoTicket myLottoTicket;
    private int correctAmount;

    public LottoResult(LottoTicket myLottoTicket, List<Integer> winningNumbers) {
        this.myLottoTicket = myLottoTicket;
        confirmLotto(winningNumbers);
    }

    private void confirmLotto(List<Integer> winnigNumbers) {
        for (Integer winningNumber : winnigNumbers) {
            confirmNumber(winningNumber);
        }
    }

    private void confirmNumber(int winnginNumber) {
        if (myLottoTicket.hasNumber(winnginNumber)) {
            correctAmount++;
        }
    }

    public boolean isEqualToAmount(int winningAmount) {
        return this.correctAmount == winningAmount;
    }
}
