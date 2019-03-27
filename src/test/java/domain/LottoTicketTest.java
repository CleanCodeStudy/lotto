package domain;

import org.junit.Test;
import util.numberGenerator.FixedNumberGenerator;
import util.numberGenerator.NumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    public void 로또생성() {
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket = new LottoTicket(fixedNumberGenerator);

        assertThat(lottoTicket.getNumbers()).contains(1, 2, 3, 4, 5, 6);
    }


    @Test
    public void 번호_몇개_일치하는지_확인() {
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket lottoTicket = new LottoTicket(fixedNumberGenerator);

        List<Integer> winningNumbers = Arrays.asList(4, 5, 6, 7, 8, 9);

        int matchAmount = lottoTicket.getCountOfMatch(winningNumbers);
        assertThat(matchAmount).isEqualTo(3);

    }

    @Test
    public void 수동으로_입력한_번호로_로또생성하기() {
        NumberGenerator numberGenerator;
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numberGenerator = new FixedNumberGenerator(numbers);
        LottoTicket lottoTicket = new LottoTicket(numberGenerator);

        assertThat(lottoTicket.getNumbers()).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void 보너스_번호_가지고있는지_확인하기() {
        NumberGenerator numberGenerator;
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numberGenerator = new FixedNumberGenerator(numbers);
        LottoTicket lottoTicket = new LottoTicket(numberGenerator);

        int bonus = 3;
        assertThat(lottoTicket.hasBonus(bonus)).isTrue();

        bonus = 45;
        assertThat(lottoTicket.hasBonus(bonus)).isFalse();

    }
}