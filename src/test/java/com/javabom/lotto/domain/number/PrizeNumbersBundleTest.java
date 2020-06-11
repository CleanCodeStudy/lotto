package com.javabom.lotto.domain.number;

import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.utils.GameNumberConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeNumbersBundleTest {

    @DisplayName("당첨 번호와 보너스 번호가 겹치면 IllegalArgumentException 을 발생시킨다")
    @Test
    void checkDuplicate() {
        List<String> prizeNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        String bonusNumber = "6";
        assertThatThrownBy(() -> new PrizeNumbersBundle(prizeNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력하신 보너스 번호는 당첨 번호와 겹칩니다.");
    }

    @DisplayName("당첨 번호와 보너스 번호의 일치 갯수의 값을 확인한다.")
    @ParameterizedTest
    @CsvSource({"10,SECOND", "20,THIRD"})
    void searchResult(String bonusNumber, String expected) {
        List<String> prizeNumbers = Arrays.asList("1", "3", "5", "7", "9", "11");
        PrizeNumbersBundle prizeNumberBundle = new PrizeNumbersBundle(prizeNumbers, bonusNumber);

        LottoTicket lottoTicket = new LottoTicket(
                GameNumberConverter.convert(Arrays.asList("1", "3", "5", "7", "9", "10")));

        LottoResult lottoResult = prizeNumberBundle.searchResult(lottoTicket);
        assertThat(lottoResult).isEqualTo(LottoResult.valueOf(expected));
    }
}