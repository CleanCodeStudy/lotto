package com.javabom.lotto.domain.info;

import com.javabom.lotto.domain.result.LottoResult;

import java.util.List;

public class PrizeNumberInfo {

    private final int BONUS_COUNT = 45;

    private PrizeNumbers prizeNumbers;
    private BonusNumber bonusNumber;

    public PrizeNumberInfo(List<String> prizeNumbers, String bonusNumber) {
        this.prizeNumbers = new PrizeNumbers(prizeNumbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
        checkDuplicate();
    }

    private void checkDuplicate() {
        if (prizeNumbers.has(bonusNumber)) {
            throw new IllegalArgumentException("입력하신 보너스 번호는 당첨 번호와 겹칩니다.");
        }
    }

    public LottoResult matchLotto(Lotto lotto) {
        int matchedCount = prizeNumbers.getMatchedCount(lotto);
        if (bonusNumber.isValid(lotto, matchedCount)) {
            return new LottoResult(matchedCount + BONUS_COUNT);
        }
        return new LottoResult(matchedCount);
    }
}
