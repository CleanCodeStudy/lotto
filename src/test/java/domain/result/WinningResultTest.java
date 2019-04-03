package domain.result;

import domain.PurchasedLottos;
import org.junit.Test;
import domain.factory.FlexibleNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningResultTest {

    @Test
    public void 일등이등_당첨후_수입률_계산() {
        //given
        PurchasedLottos purchasedLottos = new PurchasedLottos(2000, new FlexibleNumberGenerator(1));
        List<String> winningNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        WinningResult winningResult = purchasedLottos.confirmLottos(purchasedLottos, winningNumbers);

        //when
        double yield = winningResult.getYield();

        //then
        assertThat(yield).isEqualTo(1.00075E8);
    }

    @Test
    public void 구매한_로또리스트에_삼등이_몇개있는지_확인() {
        //given
        PurchasedLottos purchasedLottos = new PurchasedLottos(3000, new FlexibleNumberGenerator(1));
        List<String> winningNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");

        WinningResult winningResult = purchasedLottos.confirmLottos(purchasedLottos, winningNumbers);

        //when
        long count = winningResult.getResult(Rank.삼등);

        //then
        assertThat(count).isEqualTo(1);
    }
}