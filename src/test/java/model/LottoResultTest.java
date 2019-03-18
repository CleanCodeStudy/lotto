package model;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class LottoResultTest {

    @Test
    public void 수익률_계산하기() {

        //given
        LottoGame lottoGame = TestDatas.makeMyLottoGame();
        Map<LottoRank, Integer> lottoRankIntegerMap = lottoGame.makeResult();

        LottoResult lottoResult = new LottoResult(lottoRankIntegerMap, 3000);

        //when
        float yield = lottoResult.getYield();

        //then
        assertEquals(35.7,LottoResult.yieldFormula(14000,5000),0.1);
    }
}