package dto;

import domain.LottoTicket;
import domain.WinningLotto;
import domain.bundle.FixedLottoBundle;
import domain.bundle.LottoBundle;
import org.assertj.core.api.MapAssert;
import org.junit.Test;
import util.PrizeGroup;
import util.numberGenerator.FixedNumberGenerator;
import util.numberGenerator.NumberGenerator;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultDtoTest {

    @Test
    public void 로또_가격_맞는지_확인하기() {
        //given
        int price = 6000;
        int bonus = 45;
        List<Integer> win1 = Arrays.asList(1, 2, 3, 4, 5, 6);

        WinningLotto winningLotto = new WinningLotto(win1, bonus);

        List<LottoTicket> fixedLottoTickets = new ArrayList<>();
        fixedLottoTickets.add(new LottoTicket(new FixedNumberGenerator(Arrays.asList(1, 2, 3, 4, 5, 6))));//1등
        fixedLottoTickets.add(new LottoTicket(new FixedNumberGenerator(Arrays.asList(3, 4, 5, 6, 7, 8))));//5등
        fixedLottoTickets.add(new LottoTicket(new FixedNumberGenerator(Arrays.asList(5, 6, 7, 8, 9, 10))));//0
        fixedLottoTickets.add(new LottoTicket(new FixedNumberGenerator(Arrays.asList(7, 8, 9, 10, 11, 12))));//0
        fixedLottoTickets.add(new LottoTicket(new FixedNumberGenerator(Arrays.asList(9, 10, 11, 12, 13, 14))));//0
        fixedLottoTickets.add(new LottoTicket(new FixedNumberGenerator(Arrays.asList(11, 12, 13, 14, 15, 16))));//0

        //when
        FixedLottoBundle fixedLottoList = new FixedLottoBundle(fixedLottoTickets);
        LottoResultDto lottoResultDto = new LottoResultDto(fixedLottoList, winningLotto);

        //then
        assertThat(lottoResultDto.getSumOfReward()).isEqualTo(2000050000);
    }

    @Test
    public void 수익률_계산하기() {
        //given
        int price = 6000;
        double rate = (double) (2000050000 - 6000) / 6000 * 100;

        int bonus = 45;
        List<Integer> win1 = Arrays.asList(1, 2, 3, 4, 5, 6);

        WinningLotto winningLotto = new WinningLotto(win1, bonus);

        List<LottoTicket> fixedLottoTickets = new ArrayList<>();
        fixedLottoTickets.add(new LottoTicket(new FixedNumberGenerator(Arrays.asList(1, 2, 3, 4, 5, 6))));
        fixedLottoTickets.add(new LottoTicket(new FixedNumberGenerator(Arrays.asList(3, 4, 5, 6, 7, 8))));
        fixedLottoTickets.add(new LottoTicket(new FixedNumberGenerator(Arrays.asList(5, 6, 7, 8, 9, 10))));
        fixedLottoTickets.add(new LottoTicket(new FixedNumberGenerator(Arrays.asList(7, 8, 9, 10, 11, 12))));
        fixedLottoTickets.add(new LottoTicket(new FixedNumberGenerator(Arrays.asList(9, 10, 11, 12, 13, 14))));
        fixedLottoTickets.add(new LottoTicket(new FixedNumberGenerator(Arrays.asList(11, 12, 13, 14, 15, 16))));

        //when
        FixedLottoBundle fixedLottoList = new FixedLottoBundle(fixedLottoTickets);
        LottoResultDto lottoResultDto = new LottoResultDto(fixedLottoList, winningLotto);

        //then
        assertThat(lottoResultDto.getRate()).isEqualTo(rate);
    }


    @Test
    public void 우승_로또랑_내가_수동으로_뽑은_로또_비교하기() {
        int bonus = 7;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);

        List<Integer> allMatchNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> matchFive = Arrays.asList(45, 2, 3, 4, 5, 6);
        List<Integer> matchFiveWithBonus = Arrays.asList(1, 2, 3, 4, 5, 7);

        NumberGenerator numberGenerator = new FixedNumberGenerator(allMatchNumbers);
        LottoTicket allMatchTicket = new LottoTicket(numberGenerator);
        LottoTicket allMatchTicket2 = new LottoTicket(numberGenerator);
        numberGenerator = new FixedNumberGenerator(matchFive);
        LottoTicket matchFiveTicket = new LottoTicket(numberGenerator);
        numberGenerator = new FixedNumberGenerator(matchFiveWithBonus);
        LottoTicket matchFiveWithBonusTicket = new LottoTicket(numberGenerator);

        List<LottoTicket> lottoTickets = Arrays.asList(allMatchTicket, allMatchTicket2, matchFiveTicket, matchFiveWithBonusTicket);

        LottoBundle lottoBundle = new FixedLottoBundle(lottoTickets);

        LottoResultDto lottoResultDto = new LottoResultDto(lottoBundle, winningLotto);

        //로또 티켓 하나를 꺼내서 그거랑 위닝 로또랑 비교해서
        //그에 해당하는 로또 랭크를 반환하자.
        Map<PrizeGroup, Integer> expect = new HashMap<>();

        expect.put(PrizeGroup.FIRST, 2);
        expect.put(PrizeGroup.SECOND, 1);
        expect.put(PrizeGroup.THIRD, 1);

        MapAssert mapAssert = new MapAssert(expect);

        mapAssert.containsAllEntriesOf(lottoResultDto.getPrizeMap());

    }
}