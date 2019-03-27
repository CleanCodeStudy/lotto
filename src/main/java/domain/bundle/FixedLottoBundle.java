package domain.bundle;

import domain.LottoTicket;

import java.util.List;

/*
테스트를 위해 만들었음.
 */
public class FixedLottoBundle extends LottoBundle {

    public FixedLottoBundle(List<LottoTicket> lottoTicketList) {
        super.lottoTickets = lottoTicketList;
    }

    @Override
    protected List<LottoTicket> buyLotto(int price) {
        return null;
    }
}
