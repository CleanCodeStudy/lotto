package model;

import org.junit.Test;
import util.FixedListGeneratorImpl;
import util.RandomListGeneratorImpl;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

import java.util.List;

import static org.junit.Assert.*;

public class LottoMachineTest {
    @Test
    public void 입력_가격만큼_로또_티켓_랜덤_생성_사이즈확인() {
        int myPurchaseMoney = 60000;
        int defaultPrice = 1000;
        int numberOfLottos= myPurchaseMoney/defaultPrice;

        RandomListGeneratorImpl randomListGenerator = new RandomListGeneratorImpl();
        LottoMachine lottoMachine = new LottoMachine(myPurchaseMoney,randomListGenerator);
        List<LottoTicket> lottoTickets = lottoMachine.getLottoTickets();

        assertEquals(numberOfLottos,lottoTickets.size());
    }

    @Test
    public void 입력_가격만큼_로또_티켓_고정_생성_인자확인() {
        int myPurchaseMoney = 60000;

        FixedListGeneratorImpl fixedListGenerator= new FixedListGeneratorImpl();
        LottoMachine lottoMachine = new LottoMachine(myPurchaseMoney,fixedListGenerator);
        List<LottoTicket> lottoTickets = lottoMachine.getLottoTickets();

        assertThat(lottoTickets.get(0).getNumbers(), contains(1, 2, 3, 4, 5, 6));
    }
}