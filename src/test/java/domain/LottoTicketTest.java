package domain;

import domain.vo.LottoNumber;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    public void 수동로또의_번호확인하기() {
        //given
        //when
        LottoTicket lottoTicket = LottoTicket.createManualLotto("1,2,3,4,5,6");
        //then
        for (int i = 1; i <=6 ; i++) {
            LottoNumber lottoNumber = LottoNumber.pickNumber(i);
            assertThat(lottoTicket.hasNumber(lottoNumber)).isTrue();
        }
    }
}