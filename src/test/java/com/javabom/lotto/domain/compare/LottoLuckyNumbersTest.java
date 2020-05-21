package com.javabom.lotto.domain.compare;

import com.javabom.lotto.domain.ticket.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoLuckyNumbersTest {

    @DisplayName("객체 생성시 넣은 로또 기본 번호 제대로 나오는지 확인")
    @Test
    void getBasicNumbers() {
        // given
        List<LottoNumber> expectedLottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));
        LottoNumber bonusNumber = new LottoNumber(7);
        LottoBasicLuckyNumbers basicLuckyNumbers = new LottoBasicLuckyNumbers(expectedLottoNumbers);

        LottoLuckyNumbers lottoLuckyNumbers = new LottoLuckyNumbers(basicLuckyNumbers, bonusNumber);

        // then
        assertThat(lottoLuckyNumbers.getBasicNumbers()).isEqualTo(expectedLottoNumbers);
    }
    // LottoBasicLuckyNumbers 의 get()을 테스트하지 않았는데,
    // 그 상위인 LottoLuckyNumbers에서 위 메소드를 부르니 테스트를 또 할 필요가 없다고 판단하였습니다.
    // 오히려 반대로 LottoBasicLuckyNumbers에서 테스트하고, 상위인 LottoLuckyNumbers에서 테스트를 하지 말아야하나요?

    @DisplayName("객체 생성시 넣은 로또 보너스 번호 제대로 나오는지 확인")
    @Test
    void getBonusNumber() {
        // given
        List<LottoNumber> stubLottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));
        LottoNumber bonusNumber = new LottoNumber(7);
        LottoBasicLuckyNumbers basicLuckyNumbers = new LottoBasicLuckyNumbers(stubLottoNumbers);

        LottoLuckyNumbers lottoLuckyNumbers = new LottoLuckyNumbers(basicLuckyNumbers, bonusNumber);

        // then
        assertThat(lottoLuckyNumbers.getBonusNumber()).isEqualTo(bonusNumber);
    }
}
