package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.number.GameNumber;
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
        List<GameNumber> gameNumbers = Arrays.asList(
                GameNumber.valueOf(1),GameNumber.valueOf(1),GameNumber.valueOf(2),
                GameNumber.valueOf(3),GameNumber.valueOf(4),GameNumber.valueOf(5));
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
        List<GameNumber> gameNumbers = GameNumberConverter.convert(strGameNumbers);
        LottoTicket lottoTicket = new LottoTicket(gameNumbers);

        GameNumber gameNumber = GameNumber.valueOf(number);

        assertThat(lottoTicket.contains(gameNumber)).isEqualTo(expected);
    }

    @DisplayName("로또 티켓의 번호와 당첨 번호의 번호가 일치하면 당첨 갯수를 증가시킨다.")
    @ParameterizedTest
    @CsvSource({"3,1", "7,0"})
    void match(int number, int expected){
        List<String> strGameNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<GameNumber> gameNumbers = GameNumberConverter.convert(strGameNumbers);
        LottoTicket lottoTicket = new LottoTicket(gameNumbers);

        GameNumber prizeNumber = GameNumber.valueOf(number);
        lottoTicket.match(prizeNumber, 2);
        assertThat(lottoTicket.getMatchedCount()).isEqualTo(expected);
    }
}