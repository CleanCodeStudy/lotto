package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoListTest {

    @Test
    public void 가격을_넣었을때_가격만큼_로또생성() {
        //given
        int price = 14000;
        //when
        LottoList lottoList = new LottoList(price);
        //then
        assertThat(lottoList.getLottos().size()).isEqualTo(14);
    }

    @Test
    public void 로또_만든거_출력() {
        //given
        int price = 14000;
        //when
        LottoList lottoList = new LottoList(price);
        //then
        lottoList.showList();
    }
}