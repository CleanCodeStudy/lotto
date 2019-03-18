package controller;

import model.Lotto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LottoControllerTest {

    @Test
    public void 구입한_로또리스트_확인() {
        LottoController lottoController = new LottoController();

        int lottoCount = 7;

        List<Lotto> lottoList = lottoController.makePurchaseLottoList(lottoCount);
        assertEquals(lottoCount, lottoList.size());
    }
}