package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.info.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMachineTest {

    @DisplayName("랜덤한 값으로 로또 번호가 당첨되는지 확인한다.")
    @Test
    void createLotto() {
        RandomMachine randomMachine = new RandomMachine(new FixedGenerateLottoNumber());
        Lotto actual = randomMachine.createLotto();

        assertThat(actual.get(0)).isEqualTo(1);
        assertThat(actual.get(1)).isEqualTo(2);
        assertThat(actual.get(2)).isEqualTo(3);
        assertThat(actual.get(3)).isEqualTo(4);
        assertThat(actual.get(4)).isEqualTo(5);
        assertThat(actual.get(5)).isEqualTo(6);
    }
}