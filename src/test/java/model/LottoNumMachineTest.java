package model;

import org.junit.Test;

import java.util.List;

public class LottoNumMachineTest {



    @Test
    public void 입력_가격만큼_로또_티켓_랜덤_생성_사이즈확인() {
        int myPurchaseMoney = 60000;
        int defaultPrice = 1000;
        int numberOfLottos= myPurchaseMoney/defaultPrice;

//        RandomListGeneratorImpl randomListGenerator = new RandomListGeneratorImpl();
//        List<LottoTicket> lottoTickets = new ArrayList<>();
//        LottoMachine lottoMachine = new LottoMachine(myPurchaseMoney, lottoTickets, randomListGenerator);
//
//        assertEquals(lottoMachine.getLottoTickets().get(0),lottoTickets.size());
    }

    @Test
    public void 입력_가격만큼_로또_티켓_고정_생성_인자확인() {
        int myPurchaseMoney = 60000;

//        FixedListGeneratorImpl fixedListGenerator= new FixedListGeneratorImpl();
//        List<LottoTicket> manualLottoTickets = new ArrayList<>();
//        LottoMachine lottoMachine = new LottoMachine(myPurchaseMoney, manualLottoTickets ,fixedListGenerator);
//
//        assertThat(lottoMachine.getLottoTickets().get(0).getNumbers(), contains(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void 자동로또_구매_개수_확인 () {
        int myPurchaseMoney = 60000;
        int manualTicketCount = 3;

//        FixedListGeneratorImpl fixedListGenerator= new FixedListGeneratorImpl();
//        List<LottoTicket> manualLottoTickets = makeManualLottoTicketRandomly(manualTicketCount);
//        LottoMachine lottoMachine = new LottoMachine(myPurchaseMoney, manualLottoTickets, fixedListGenerator);
//
//        assertEquals(lottoMachine.getAutoLottoTicketCount(), 57);
    }

//    public List<LottoTicket> makeManualLottoTicketRandomly(int count){
////        RandomListGeneratorImpl randomListGenerator = new RandomListGeneratorImpl();
////        List<LottoTicket> lottoTickets = new ArrayList<>();
////        for(int i=0 ; i<count; i++){
////            lottoTickets.add(new LottoTicket(randomListGenerator.getSixList()));
////        }
////        return lottoTickets;
//    }
}