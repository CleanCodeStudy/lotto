package model;

import org.junit.Test;
import util.FixedListGeneratorImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class LottoYieldTest {
    @Test
    public void 수익률_계산() {
        final List<Integer> correctAnswer = Arrays.asList(3,4,5,6,7,8);
        FixedListGeneratorImpl fixedListGenerator =new FixedListGeneratorImpl();
        LottoMachine lottoMachine = new LottoMachine(6000, fixedListGenerator);
        LottoGame lottoGame = new LottoGame(correctAnswer, lottoMachine);
        LottoYield lottoYield = new LottoYield(lottoGame, 6000);


        //
        assertEquals(5000,lottoYield.analyzeYield(),0.5);
    }
}