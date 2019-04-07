package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void 만사천원을_넣었을때_가격만큼_로또생성() {
        //given
        int price = 2000;
        List<String> manualLottos = Arrays.asList("1,2,3,4,5,6","1,2,3,4,5,7");
        //when
        LottoGame lottoGame = new LottoGame(price,manualLottos);
        //then
        assertThat(lottoGame.getLottoTickets().size()).isEqualTo(2);

    }
}