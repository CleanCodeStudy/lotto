package domain.result;

import domain.Lotto;
import org.junit.Test;
import util.FlexibleNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RankTest {

    @Test
    public void 삼등이_몇개_당첨되었는지_확인() {
        //given
        Lotto lotto = new Lotto(new FlexibleNumberGenerator(1));
        List<LottoResult> lottoResults = Arrays.asList(createLottoResult(),createLottoResult());

        //when
        long winAmount = Rank.삼등.count(lottoResults);

        //then
        assertThat(winAmount).isEqualTo(2);
    }

    private LottoResult createLottoResult(){
        Lotto lotto = new Lotto(new FlexibleNumberGenerator(1));
        return new LottoResult(lotto, Arrays.asList(3,4,5,6,7,8));
    }
}