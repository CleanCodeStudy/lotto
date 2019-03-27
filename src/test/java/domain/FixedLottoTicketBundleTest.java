package domain;

import domain.bundle.FixedLottoBundle;
import domain.bundle.LottoBundle;
import org.junit.Test;
import util.numberGenerator.FixedNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FixedLottoTicketBundleTest {

    @Test
    public void 특정개수_맞은애들_몇개인지_가져오기() {
        //given
        int price = 6000;
        List<Integer> win1 = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<LottoTicket> fixedLottoTickets = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            fixedLottoTickets.add(new LottoTicket(new FixedNumberGenerator(Arrays.asList(i, i + 1, i + 2, i + 3, i + 4, i + 5))));
        }

        LottoBundle fixedLottoBundle = new FixedLottoBundle(fixedLottoTickets);

        for (int i = 0; i < fixedLottoBundle.getLottoTickets().size(); i++) {
            System.out.println(fixedLottoBundle.getLottoTickets().get(i).getNumbers());
        }

        //when
        int one = fixedLottoBundle.getCountOfMatch(1, win1);
        int two = fixedLottoBundle.getCountOfMatch(2, win1);
        int three = fixedLottoBundle.getCountOfMatch(3, win1);
        int four = fixedLottoBundle.getCountOfMatch(4, win1);
        int five = fixedLottoBundle.getCountOfMatch(5, win1);
        int six = fixedLottoBundle.getCountOfMatch(6, win1);

        //then
        assertThat(one).isEqualTo(1);
        assertThat(two).isEqualTo(1);
        assertThat(three).isEqualTo(1);
        assertThat(four).isEqualTo(1);
        assertThat(five).isEqualTo(1);
        assertThat(six).isEqualTo(1);
    }

}