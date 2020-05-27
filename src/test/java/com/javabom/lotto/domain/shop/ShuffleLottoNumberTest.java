package com.javabom.lotto.domain.shop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ShuffleLottoNumberTest {

    @DisplayName("랜덤으로 값을 뽑았을 때 6개의 값이 잘 나오는지 확인한다.")
    @Test
    public void picked() {
        FixedGenerateLottoNumber fixedLottoNumber = new FixedGenerateLottoNumber();
        List<Integer> actual = fixedLottoNumber.picked();
        assertThat(actual.get(0)).isEqualTo(1);
        assertThat(actual.get(1)).isEqualTo(2);
        assertThat(actual.get(2)).isEqualTo(3);
        assertThat(actual.get(3)).isEqualTo(4);
        assertThat(actual.get(4)).isEqualTo(5);
        assertThat(actual.get(5)).isEqualTo(6);
    }
}