package domain;

import domain.bundle.RandomLottoBundle;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoTicketBundleTest {

    @Test
    public void 가격을_넣었을때_가격만큼_로또생성() {
        //given
        int price = 14000;
        //when
        RandomLottoBundle randomLottoList = new RandomLottoBundle(price);
        //then
        assertThat(randomLottoList.getLottoTickets().size()).isEqualTo(14);
    }

    @Test
    public void 로또_만든거_출력() {
        //given
        int price = 14000;
        //when
        RandomLottoBundle randomLottoList = new RandomLottoBundle(price);
        //then
        randomLottoList.showList();
    }
}