package com.javabom.lotto.domain.utils;

import com.javabom.lotto.domain.number.GameNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameNumberConverterTest {

    @DisplayName("로또 번호 숫자들을 잘 반환하는지 확인한다.")
    @Test
    void convert(){
        GameNumberConverter gameNumberConverter = new GameNumberConverter();

        List<String> strGameNumber = Arrays.asList("1","2","3","4","5","6");
        List<GameNumber> actual = gameNumberConverter.convert(strGameNumber);

        assertThat(actual.get(0)).isEqualTo(GameNumber.valueOf(1));
        assertThat(actual.get(1)).isEqualTo(GameNumber.valueOf(2));
        assertThat(actual.get(2)).isEqualTo(GameNumber.valueOf(3));
        assertThat(actual.get(3)).isEqualTo(GameNumber.valueOf(4));
        assertThat(actual.get(4)).isEqualTo(GameNumber.valueOf(5));
        assertThat(actual.get(5)).isEqualTo(GameNumber.valueOf(6));
    }
}
