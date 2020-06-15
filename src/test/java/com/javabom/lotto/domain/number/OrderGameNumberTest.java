package com.javabom.lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class OrderGameNumberTest {

    @DisplayName("인덱스 범위가 넘어가면 IllegalArgumentException을 발생시킨다.")
    @Test
    void checkOrderRange(){
        int actual = 10;
        assertThatThrownBy(() -> OrderGameNumber.of(actual, GameNumber.valueOf(actual)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("%d, 게임 숫자의 인덱스 범위는 1-6 이어야 합니다.", actual));
    }

    @DisplayName("로또 번호가 같으면 true, 다르면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource({"10,true", "20,flase"})
    void equalsOfNumber(int inputGameNumber, boolean expected){
        GameNumber gameNumber = GameNumber.valueOf(10);
        OrderGameNumber orderGameNumber = OrderGameNumber.of(3, gameNumber);

        OrderGameNumber actualGameNumber = OrderGameNumber.of(7, GameNumber.valueOf(inputGameNumber));

        assertThat(orderGameNumber.equalsOfNumber(actualGameNumber)).isEqualTo(expected);
    }
}
