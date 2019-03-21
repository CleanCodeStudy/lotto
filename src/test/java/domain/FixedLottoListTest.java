package domain;

import org.junit.Test;
import util.FixedNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FixedLottoListTest {

    @Test
    public void 특정개수_맞은애들_몇개인지_가져오기() {
        //given
        int price = 6000;
        List<Integer> win1 = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Lotto> fixedLottos = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            fixedLottos.add(new Lotto(new FixedNumberGenerator(i)));
        }

        LottoList fixedLottoList = new FixedLottoList(fixedLottos);

        for (int i = 0; i < fixedLottoList.getLottos().size(); i++) {
            System.out.println(fixedLottoList.getLottos().get(i).getNumbers());
        }

        //when
        int one = fixedLottoList.getCountByMatchAmount(1, win1);
        int two = fixedLottoList.getCountByMatchAmount(2, win1);
        int three = fixedLottoList.getCountByMatchAmount(3, win1);
        int four = fixedLottoList.getCountByMatchAmount(4, win1);
        int five = fixedLottoList.getCountByMatchAmount(5, win1);
        int six = fixedLottoList.getCountByMatchAmount(6, win1);

        //then
        assertThat(one).isEqualTo(1);
        assertThat(two).isEqualTo(1);
        assertThat(three).isEqualTo(1);
        assertThat(four).isEqualTo(1);
        assertThat(five).isEqualTo(1);
        assertThat(six).isEqualTo(1);
    }

}