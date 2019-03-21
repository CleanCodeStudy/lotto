package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoListTest {

    @Test
    public void 가격을_넣었을때_가격만큼_로또생성() {
        //given
        int price = 14000;
        //when
        RandomLottoList randomLottoList = new RandomLottoList(price);
        //then
        assertThat(randomLottoList.getLottos().size()).isEqualTo(14);
    }

    @Test
    public void 로또_만든거_출력() {
        //given
        int price = 14000;
        //when
        RandomLottoList randomLottoList = new RandomLottoList(price);
        //then
        randomLottoList.showList();
    }
}