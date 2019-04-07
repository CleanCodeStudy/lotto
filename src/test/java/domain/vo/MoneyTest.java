package domain.vo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void 돈_4500원_생성() {
        //given
        long money = 4500L;
        //when
        Money actual = new Money(money);
        //then
        assertThat(actual.getMoney()).isEqualTo(money);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수의_돈은_예외발생() {
        //given
        long money = -1L;
        //when
        //then
        Money actual = new Money(money);
    }

    @Test
    public void 만원을_넣을시_살수_있는_로또수_10장() {
        //given
        long money = 10000L;
        //when
        Money actual = new Money(money);
        //then
        assertThat(actual.getAmountOfLotto()).isEqualTo(10);
    }

    @Test
    public void 구매한_로또수로_투자금_반환() {
        //given
        int count = 10;
        //when
        Money money = Money.getInvestment(count);
        //then
        assertThat(money.getMoney()).isEqualTo(10000L);
    }

    @Test
    public void 투자한_금액의_이율반환() {
        //given
        Money investment = new Money(1000L);
        Money prize = new Money(10000L);
        //when
        double yield = prize.calculate(investment);
        //then
        assertThat(yield).isEqualTo(900.0);
    }
}