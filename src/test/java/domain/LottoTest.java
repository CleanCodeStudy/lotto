package domain;

import org.junit.Test;
import util.FixedNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 로또생성() {
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(0);
        Lotto lotto = new Lotto(fixedNumberGenerator);

        assertThat(lotto.getNumbers()).contains(1, 2, 3, 4, 5, 6);
    }


    @Test
    public void 번호_몇개_일치하는지_확인() {
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(0);
        Lotto lotto = new Lotto(fixedNumberGenerator);

        List<Integer> winningNumbers = Arrays.asList(4, 5, 6, 7, 8, 9);

        int matchAmount = lotto.getMatchAmount(winningNumbers);
        assertThat(matchAmount).isEqualTo(3);

    }

}