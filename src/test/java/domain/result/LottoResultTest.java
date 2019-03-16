package domain.result;

import domain.Lotto;
import domain.result.LottoResult;
import org.junit.Test;
import util.FlexibleNumberGenerator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    public void 로또_세개_맞았는지_확인() {
        //given
        FlexibleNumberGenerator flexibleNumberGenerator = new FlexibleNumberGenerator(1);
        Lotto lotto = new Lotto(flexibleNumberGenerator);

        //when
        LottoResult lottoResult = new LottoResult(lotto,Arrays.asList(4,5,6,7,8,9));
        //then

        assertThat(lottoResult.isEqualToAmount(3)).isTrue();
    }
}