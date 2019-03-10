package domain;

import org.junit.Test;
import util.FixedNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 로또생성(){
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator();
        Lotto lotto = new Lotto(fixedNumberGenerator);

        assertThat(lotto.getNumbers()).contains(1,2,3,4,5,6);
    }

}