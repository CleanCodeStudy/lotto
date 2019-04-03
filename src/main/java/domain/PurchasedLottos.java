package domain;

import domain.result.WinningResult;
import domain.factory.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos {
    private static final int LOTTO_PRICE = 1000;

    private List<LottoTicket> lottoTickets;
    private long price;

    public PurchasedLottos(long price, NumberGenerator numberGenerator) {
        this.lottoTickets = buyLotto(price, numberGenerator);
        this.price = price;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public long getPrice() {
        return price;
    }

    private List<LottoTicket> buyLotto(long price, NumberGenerator numberGenerator) {
        long amountOfLotto = price / LOTTO_PRICE;

        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < amountOfLotto; i++) {
            lottoTickets.add(new LottoTicket(numberGenerator));
        }

        return lottoTickets;
    }

    public WinningResult confirmLottos(PurchasedLottos purchasedLottos, List<String> inputWinningNumber) {
        return new WinningResult(purchasedLottos,inputWinningNumber);
    }
}

