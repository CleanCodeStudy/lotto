package model;

import org.junit.Test;
import util.FixedListGeneratorImpl;

import java.util.*;

import static org.junit.Assert.assertEquals;


public class LottoGameTest {

    private boolean areEqual(Map<LottoRank, Integer> first, Map<LottoRank, Integer> second) {
        if (first.size() != second.size()) {
            return false;
        }
        return first.entrySet().stream()
                .allMatch(e -> e.getValue().equals(second.get(e.getKey())));
    }

    @Test
    public void 현재_로또_게임의_결과_반환() {

        //나의 로또게임
        LottoGame myLottoGame = TestDatas.makeMyLottoGame();

        Map<LottoRank, Integer> lottoMap = myLottoGame.makeResult();

        //기대하는 로또게임
        Map<LottoRank, Integer> expectedMap = TestDatas.makeExpectedLottoResultMap();

        assertEquals(true, areEqual(expectedMap, lottoMap));
    }


}