package util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @Test
    public void 가격계산() {
        int price = 5000;
        Prize prize = new Prize(price);

        assertThat(prize.getPrize(4)).isEqualTo(20000);
    }
}