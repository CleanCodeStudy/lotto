package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LottoNumTicketTest {

    @Test
    public void 랜덤으로_뽑은_LottoTicket_생성하기() {
        LottoTicket ticket = new LottoTicket();

        ticket.printList();

        assertEquals(6, ticket.size());
    }

    @Test
    public void 수동으로_뽑은_LottoTicket_생성하기() {
        LottoTicket ticket = new LottoTicket("1,2,3,4,5,6");

        ticket.printList();
    }

    @Test
    public void 맞춘_정답개수_보기() {
        LottoTicket myTicket = new LottoTicket("1,2,3,4,5,6");
        LottoTicket collectTicket = new LottoTicket("1,2,3,7,8,9");
        int count = myTicket.getCollectCount(collectTicket);

        assertEquals(3, count);
    }

    @Test
    public void 배열포함여부_보기() {
        LottoTicket myTicket = new LottoTicket("1,2,3,4,5,6");
        boolean result = myTicket.contains(new LottoNum(1));

        assertEquals(true, result);
    }
}