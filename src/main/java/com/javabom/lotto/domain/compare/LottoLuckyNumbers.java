package com.javabom.lotto.domain.compare;

import com.javabom.lotto.domain.ticket.LottoNumber;

import java.util.Collections;
import java.util.List;

public class LottoLuckyNumbers {

    private final LottoBasicLuckyNumbers basicNumbers;
    private final LottoNumber bonusNumber;

    public LottoLuckyNumbers(LottoBasicLuckyNumbers basicNumbers, LottoNumber bonusNumber) {
        this.basicNumbers = basicNumbers;
        this.bonusNumber = bonusNumber;
    }

    // 이미 basicNumbers.get() 내부에서 unmodifiableList로 감싸서 던져주는것을
    // 한 번더 감싸는 것이 안전하다고 판단하였습니다.
    public List<LottoNumber> getBasicNumbers() {
        return Collections.unmodifiableList(basicNumbers.get());
    }

    // 이 LottoNumber는 불변객체라고 생각해서 그냥 반환하였는데,
    // LottoNumber 내부에 copy해주는 메소드를 추가하여 복사본을 반환하는게 더 나은가요?
    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
