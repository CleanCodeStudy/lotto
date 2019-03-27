package domain.bundle;

import domain.LottoTicket;
import util.numberGenerator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ManualLottoBundle extends LottoBundle {

    final private List<LottoTicket> manualTickets;

    public ManualLottoBundle(int price, List<LottoTicket> manualTickets) {
        this.manualTickets = manualTickets;
        super.lottoTickets = buyLotto(price);
    }

    @Override
    protected List<LottoTicket> buyLotto(int price) {
        final int lottoAmount = (price / LOTTO_PRICE) - manualTickets.size();

        List<LottoTicket> lottoTickets = new ArrayList<>();

        lottoTickets.addAll(manualTickets);
        lottoTickets.addAll(buyRandomTicket(lottoAmount));

        return lottoTickets;
    }

    private List<LottoTicket> buyRandomTicket(int lottoAmount) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        return IntStream.range(LOTTO_MIN_AMOUNT, lottoAmount)
                .mapToObj(loop -> new LottoTicket(randomNumberGenerator))
                .collect(Collectors.toList());
    }
}
