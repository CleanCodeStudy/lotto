package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.number.GameNumber;
import com.javabom.lotto.domain.number.OrderGameNumber;
import com.javabom.lotto.domain.number.PrizeNumbersBundle;
import com.javabom.lotto.domain.utils.GameNumberConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    @DisplayName("티켓이 갖고있는 로또 번호가 중복되면 IllegalArgumentException을 발생시킨다.")
    @Test
    void checkDuplicate() {
        List<String> strGameNumbers = Arrays.asList("1","2","3","4","5");
        List<OrderGameNumber> gameNumbers = GameNumberConverter.convert(strGameNumbers);
        int expected = 5;

        assertThatThrownBy(() -> new LottoTicket(gameNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("현재 개수: %d, 로또 번호의 갯수는 6개여야 합니다.", expected));
    }

    @DisplayName("티켓이 갖고있는 로또 번호면 true, 아니면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1,true", "7,false"})
    void contains(int number, boolean expected) {
        List<String> strGameNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<OrderGameNumber> gameNumbers = GameNumberConverter.convert(strGameNumbers);
        LottoTicket lottoTicket = new LottoTicket(gameNumbers);

        GameNumber gameNumber = GameNumber.valueOf(number);

        assertThat(lottoTicket.contains(OrderGameNumber.of(number, gameNumber))).isEqualTo(expected);
    }

    @DisplayName("티켓이 보너스 번호를 갖고있으면 true, 아니면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1,true", "7,false"})
    void containsBonus(int number, boolean expected) {
        List<String> strGameNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<OrderGameNumber> gameNumbers = GameNumberConverter.convert(strGameNumbers);
        LottoTicket lottoTicket = new LottoTicket(gameNumbers);

        GameNumber bonusNumber = GameNumber.valueOf(number);

        assertThat(lottoTicket.containsBonus(OrderGameNumber.of(7, bonusNumber))).isEqualTo(expected);
    }
}