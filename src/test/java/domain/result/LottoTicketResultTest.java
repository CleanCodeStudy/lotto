package domain.result;

import domain.LottoTicket;
import org.junit.Test;
import domain.factory.FlexibleNumberGenerator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketResultTest {

    @Test
    public void 로또_세개_맞았는지_확인() {
        //given
        FlexibleNumberGenerator flexibleNumberGenerator = new FlexibleNumberGenerator(1);
        LottoTicket lottoTicket = new LottoTicket(flexibleNumberGenerator);

        //when
        LottoResult lottoResult = new LottoResult(lottoTicket,Arrays.asList(4,5,6,7,8,9));
        //then

        assertThat(lottoResult.isEqualToAmount(3)).isTrue();
    }
}