package domain;

import org.junit.Test;
import domain.factory.FlexibleNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchasedLottosTest {

    @Test
    public void 만사천원을_넣었을때_가격만큼_로또생성() {
        //given
        int price = 14000;
        //when
        PurchasedLottos purchasedLottos = new PurchasedLottos(price,new FlexibleNumberGenerator(1));
        //then
        assertThat(purchasedLottos.getLottoTickets().size()).isEqualTo(14);
    }
}