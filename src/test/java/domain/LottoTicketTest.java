package domain;

import org.junit.Test;
import domain.factory.FlexibleNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    private LottoTicket lottoTicket;
    @Test
    public void 고정된_숫자를_넣을시_고정된_숫자를_갖는_로또생성(){
        FlexibleNumberGenerator flexibleNumberGenerator = new FlexibleNumberGenerator(1);
        List<Integer> numbers = flexibleNumberGenerator.createNumbers();

        this.lottoTicket = new LottoTicket(new FlexibleNumberGenerator(1));

        numbers.forEach(this::assertThatNumber);
    }

    private void assertThatNumber(int number){
        assertThat(lottoTicket.hasNumber(number)).isTrue();
    }
}