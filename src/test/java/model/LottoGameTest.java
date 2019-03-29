package model;

import org.junit.Test;
import util.FixedListGeneratorImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class LottoGameTest {



    @Test
    public void lottoMachine으로_뽑은lotto에대한_rankgroup_생성하기_사이즈체크() {
        final List<Integer> correctAnswer = Arrays.asList(1, 2, 3, 0, 0, 0);
        FixedListGeneratorImpl fixedListGenerator =new FixedListGeneratorImpl();
        LottoMachine lottoMachine = new LottoMachine(6000, fixedListGenerator);
        LottoGame lottoGame = new LottoGame(correctAnswer, lottoMachine);

        Map<LottoRank, List<LottoTicket>> lottoRankListMap = lottoGame.getRankLottoGroup();

        assertEquals(lottoRankListMap.get(LottoRank.FOURTH).size(), 6);
    }

    @Test
    public void rankGroup_OUT제거_keyset사이즈_체크() {
        final List<Integer> correctAnswer = Arrays.asList(1, 2, 3, 0, 0, 0);
        FixedListGeneratorImpl fixedListGenerator =new FixedListGeneratorImpl();
        LottoMachine lottoMachine = new LottoMachine(6000, fixedListGenerator);
        LottoGame lottoGame = new LottoGame(correctAnswer, lottoMachine);

        Map<LottoRank, List<LottoTicket>> lottoRankListMap = lottoGame.getRankLottoGroup();

        assertEquals(lottoRankListMap.keySet().size(), 4);
    }
}