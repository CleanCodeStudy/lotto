package model;

import org.junit.Test;
import util.FixedListGeneratorImpl;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LottoGameTest {
    @Test
    public void 로또_결과_반환() {

        List<Lotto> fixedLottoList = new ArrayList<>();
            FixedListGeneratorImpl fixedListGenerator = new FixedListGeneratorImpl();

        for (int i=0; i<3; i++){
            Lotto myLotto = new Lotto(fixedListGenerator.getSixList());
            fixedLottoList.add(myLotto);
        }
        //3개 맞춘 것 3개
        LottoGame lottoGame = new LottoGame(fixedLottoList);

        Map<LottoRank, Integer> lottoMap = lottoGame.getResult(Arrays.asList(1, 2, 11, 8, 3, 10));

        Map<LottoRank, Integer> expectedMap = new HashMap();
        expectedMap.put(LottoRank.FIRST, 0);
        expectedMap.put(LottoRank.SECOND, 0);
        expectedMap.put(LottoRank.THIRD, 0);
        expectedMap.put(LottoRank.FOURTH, 3);
        expectedMap.put(LottoRank.OUT, 0);



        assertEquals(true, areEqual(expectedMap, lottoMap));
    }

    private boolean areEqual(Map<LottoRank, Integer> first, Map<LottoRank, Integer> second) {
        if (first.size() != second.size()) {
            return false;
        }

        return first.entrySet().stream()
                .allMatch(e -> e.getValue().equals(second.get(e.getKey())));
    }
}