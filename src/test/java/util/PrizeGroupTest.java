package util;

import domain.LottoTicket;
import domain.WinningLotto;
import org.junit.Test;
import util.numberGenerator.FixedNumberGenerator;
import util.numberGenerator.NumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeGroupTest {

    @Test
    public void 우승로또와_비교해서_로또순위_반환확인() {
        List<Integer> firstRankNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> secondRankNumers = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> thirdRankNumbers = Arrays.asList(1, 2, 3, 4, 5, 45);

        List<Integer> winningnumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        NumberGenerator numberGenerator = new FixedNumberGenerator(firstRankNumbers);
        LottoTicket ticket1 = new LottoTicket(numberGenerator);
        numberGenerator = new FixedNumberGenerator(secondRankNumers);
        LottoTicket ticket2 = new LottoTicket(numberGenerator);
        numberGenerator = new FixedNumberGenerator(thirdRankNumbers);
        LottoTicket ticket3 = new LottoTicket(numberGenerator);

        WinningLotto winningLotto = new WinningLotto(winningnumbers, bonus);

        assertThat(PrizeGroup.findRankByCountOfMatchAndBonus(ticket1, winningLotto)).isEqualByComparingTo(PrizeGroup.FIRST);
        assertThat(PrizeGroup.findRankByCountOfMatchAndBonus(ticket2, winningLotto)).isEqualByComparingTo(PrizeGroup.SECOND);
        assertThat(PrizeGroup.findRankByCountOfMatchAndBonus(ticket3, winningLotto)).isEqualByComparingTo(PrizeGroup.THIRD);


    }

}