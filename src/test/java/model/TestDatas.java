package model;

import util.FixedListGeneratorImpl;

import java.util.*;

public class TestDatas {

    public static final List<Integer> correctAnswer = Arrays.asList(1, 2, 3, 7, 8, 9);

    public static LottoGame makeMyLottoGame() {
        List<Lotto> fixedLottoList = new ArrayList<>();
        FixedListGeneratorImpl fixedListGenerator = new FixedListGeneratorImpl();

        for (int i = 0; i < 3; i++) { //3개 맞춘 것 3개
            Lotto myLotto = new Lotto(fixedListGenerator.getSixList());
            fixedLottoList.add(myLotto);
        }
        List<Integer> winNumbers = correctAnswer;
        return new LottoGame(fixedLottoList, winNumbers);
    }

    public static Map<LottoRank, Integer> makeExpectedLottoResultMap() {
        Map<LottoRank, Integer> expectedMap = new HashMap();

        expectedMap.put(LottoRank.FIRST, 0);
        expectedMap.put(LottoRank.SECOND, 0);
        expectedMap.put(LottoRank.THIRD, 0);
        expectedMap.put(LottoRank.FOURTH, 3);

        return expectedMap;
    }

}
