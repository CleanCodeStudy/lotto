package domain.bundle;

import domain.LottoTicket;

import java.util.List;

public class LottoBundle {

    private static final int LOTTO_DEFAULT_PRICE = 1000;

    private List<LottoTicket> lottoTickets;
    private int manualAmount;
    private int radomAmount;

    public LottoBundle(List<LottoTicket> manual, List<LottoTicket> random) {
        this.manualAmount = manual.size();
        this.radomAmount = random.size();
        this.lottoTickets = manual;
        this.lottoTickets.addAll(random);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public int getManualAmount() {
        return manualAmount;
    }

    public int getRadomAmount() {
        return radomAmount;
    }

    public int getInputMoney() {
        return LOTTO_DEFAULT_PRICE * this.lottoTickets.size();
    }

}
