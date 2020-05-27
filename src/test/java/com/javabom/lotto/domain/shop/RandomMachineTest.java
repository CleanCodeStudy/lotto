package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.info.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomMachineTest {
    private final int MIN = 1;
    private final int MAX = 45;

    @DisplayName("생성된 번호에 대한 값을 반환하는지 확인한다.")
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

    @DisplayName("랜덤한 값으로 들어온 로또 번호가 1-45 사이인지 확인한다.")
    @Test
    void picked() {
        RandomMachine randomMachine = new RandomMachine(new ShuffleLottoNumber());
        Lotto actual = randomMachine.createLotto();
        assertTrue(actual.get(0) >= MIN && actual.get(0) <= MAX);
        assertTrue(actual.get(1) >= MIN && actual.get(1) <= MAX);
        assertTrue(actual.get(2) >= MIN && actual.get(2) <= MAX);
        assertTrue(actual.get(3) >= MIN && actual.get(3) <= MAX);
        assertTrue(actual.get(4) >= MIN && actual.get(4) <= MAX);
        assertTrue(actual.get(5) >= MIN && actual.get(5) <= MAX);
    }
}
