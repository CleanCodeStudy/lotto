package dto;

import domain.FixedLottoList;
import domain.Lotto;
import domain.LottoList;
import domain.RandomLottoList;
import org.assertj.core.api.MapAssert;
import org.junit.Test;
import util.FixedNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultDtoTest {

    @Test
    public void 가지고있는_로또들의_맞춘개수_저장하기_후_비교() {
        //given
        int price = 14000;
        List<Integer> winningNumber = Arrays.asList(4, 5, 6, 7, 8, 9);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < 12; i = i + 2) {
            lottos.add(new Lotto(new FixedNumberGenerator(i)));
        }
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).getNumbers());
        }
        //[1, 2, 3, 4, 5, 6]        -->3
        //[3, 4, 5, 6, 7, 8]        -->5
        //[5, 6, 7, 8, 9, 10]       -->5
        //[7, 8, 9, 10, 11, 12]     -->3
        //[9, 10, 11, 12, 13, 14]   -->1
        //[11, 12, 13, 14, 15, 16]  -->0

        LottoList fixedLottoList = new FixedLottoList(lottos);
        HashMap<Integer, Integer> expect = new HashMap<>();

        expect.put(3, 2);
        expect.put(4, 0);
        expect.put(5, 2);
        expect.put(6, 0);

        //when
        LottoResultDto lottoResultDto = new LottoResultDto(fixedLottoList, winningNumber);
        //then
        MapAssert mapAssert = new MapAssert(lottoResultDto.getPrizeMap());
        mapAssert.containsAllEntriesOf(expect);
    }

    @Test
    public void 로또_가격_맞는지_확인하기() {
        //given
        int price = 6000;
        List<Integer> win1 = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Lotto> fixedLottos = new ArrayList<>();
        for (int i = 2; i < 8; i++) {
            fixedLottos.add(new Lotto(new FixedNumberGenerator(i)));
        }

        //when
        FixedLottoList fixedLottoList = new FixedLottoList(fixedLottos);
        LottoResultDto lottoResultDto = new LottoResultDto(fixedLottoList, win1);

        //then
        assertThat(lottoResultDto.getPrizeSum()).isEqualTo(55000);
    }

    @Test
    public void 수익률_계산하기() {
        //given
        int price = 6000;
        double rate = (double) (55000 - 6000) / 6000 * 100;
        String expect = rate + "%";
        List<Integer> win1 = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Lotto> fixedLottos = new ArrayList<>();
        for (int i = 2; i < 8; i++) {
            fixedLottos.add(new Lotto(new FixedNumberGenerator(i)));
        }

        //when
        FixedLottoList fixedLottoList = new FixedLottoList(fixedLottos);
        LottoResultDto lottoResultDto = new LottoResultDto(fixedLottoList, win1);

        //then
        assertThat(lottoResultDto.getRate()).isEqualTo(expect);
    }

    @Test
    public void 결과_출력() {
        //given
        int price = 14000;
        RandomLottoList randomLottoList = new RandomLottoList(price);
        List<Integer> win1 = Arrays.asList(1, 2, 3, 4, 5, 6);

        //when
        List<Lotto> fixedLottos = new ArrayList<>();
        for (int i = 2; i < 8; i++) {
            fixedLottos.add(new Lotto(new FixedNumberGenerator(i)));
        }
        LottoResultDto lottoResultDto = new LottoResultDto(randomLottoList, win1);
        FixedLottoList fixedLottoList = new FixedLottoList(fixedLottos);
        LottoResultDto lottoResultDtoFixed = new LottoResultDto(fixedLottoList, win1);

        //then
        System.out.println(lottoResultDto.getResult());

        System.out.println("\n" + lottoResultDtoFixed.getResult());
    }
}