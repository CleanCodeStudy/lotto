package domain.result;

import domain.LottoTicket;
import org.junit.Test;
import domain.factory.FlexibleNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RankTest {

    @Test
    public void 삼등이_몇개_당첨되었는지_확인() {
        //given
        LottoTicket lottoTicket = new LottoTicket(new FlexibleNumberGenerator(1));
        List<LottoResult> lottoResults = Arrays.asList(createLottoResult(),createLottoResult());

        //when
        long winAmount = Rank.삼등.count(lottoResults);

        //then
        assertThat(winAmount).isEqualTo(2);
    }

    private LottoResult createLottoResult(){
        LottoTicket lottoTicket = new LottoTicket(new FlexibleNumberGenerator(1));
        return new LottoResult(lottoTicket, Arrays.asList(3,4,5,6,7,8));
    }
}