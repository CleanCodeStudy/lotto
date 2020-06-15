package com.javabom.lotto.domain.number;

import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.utils.GameNumberConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeNumbersTest {

    @DisplayName("당첨 번호에 들어있는 번호면 true, 들어있지 않는 번호면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource({"4,true", "7,false"})
    void contains(int number, boolean expected) {
        List<String> strPrizeNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        PrizeNumbers prizeNumbers = new PrizeNumbers(strPrizeNumbers);
        OrderGameNumber bonusNumber = OrderGameNumber.of(7, GameNumber.valueOf(number));
        assertThat(prizeNumbers.contains(bonusNumber)).isEqualTo(expected);
    }

    @DisplayName("당첨 번호와 로또 티켓의 일치 갯수를 확인한다.")
    @Test
    void getMatchedCount(){
        List<String> strPrizeNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        PrizeNumbers prizeNumbers = new PrizeNumbers(strPrizeNumbers);

        List<String> strGameNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<OrderGameNumber> gameNumbers = GameNumberConverter.convert(strGameNumbers);
        LottoTicket lottoTicket = new LottoTicket(gameNumbers);

        assertThat(prizeNumbers.getMatchedCount(lottoTicket)).isEqualTo(6);
    }
}
