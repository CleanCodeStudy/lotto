package model;

import data.PurchaseInfo;

import java.util.List;
import java.util.stream.Collectors;


public class LottoMachine {

    private List<LottoTicket> lottoTickets;

    public LottoMachine(PurchaseInfo purchaseInfo) {
        this.lottoTickets = makePurchaseLottoList(purchaseInfo);
    }

    private List<LottoTicket> makePurchaseLottoList(PurchaseInfo purchaseInfo) {
        List<LottoTicket> purchaseLottoTickets = buyManualLottos(purchaseInfo.getManualLottos());
        for (int i = 0; i < purchaseInfo.getAutoTicketCount(); i++) {
            purchaseLottoTickets.add(new LottoTicket());
        }
        return purchaseLottoTickets;
    }

    private List<LottoTicket> buyManualLottos(List<String> manualLottos) {
        return manualLottos.stream()
                .map(x -> new LottoTicket(x))
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

}
