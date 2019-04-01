package domain.bundle;

import domain.LottoTicket;
import domain.WinningLotto;
import util.PrizeGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoBundle {

    private static final int LOTTO_DEFAULT_PRICE = 1000;
    private static final String MANUAL_KEY = "manual";
    private static final String RANDOM_KEY = "random";

    private Map<String, List<LottoTicket>> ticketMap = new HashMap<>();

    public LottoBundle(List<LottoTicket> manual, List<LottoTicket> random) {
        ticketMap.put(MANUAL_KEY, manual);
        ticketMap.put(RANDOM_KEY, random);
    }

    public List<LottoTicket> getLottoTickets() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.addAll(this.ticketMap.get(RANDOM_KEY));
        tickets.addAll(this.ticketMap.get(MANUAL_KEY));
        return tickets;
    }

    public int getManualAmount() {
        return this.ticketMap.get(MANUAL_KEY).size();
    }

    public int getRandomAmount() {
        return this.ticketMap.get(RANDOM_KEY).size();
    }

    public int getInputMoney() {
        final int size = getManualAmount() + getRandomAmount();
        return LOTTO_DEFAULT_PRICE * size;
    }

    public List<PrizeGroup> getPrizeGroups(WinningLotto winningLotto) {
        return getLottoTickets()
                .stream()
                .map(lottoTicket -> PrizeGroup.findRankByCountOfMatchAndBonus(lottoTicket, winningLotto))
                .collect(Collectors.toList());
    }
}
