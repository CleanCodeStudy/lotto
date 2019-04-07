package domain.bundle;

import domain.LottoTicket;
import domain.prize.PrizeGroup;
import domain.WinningLotto;
import dto.LottoResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBundle {

    private List<LottoTicket> tickets;
    private int manualAmount;
    private int randomAmount;

    public LottoBundle(List<LottoTicket> manual, List<LottoTicket> random) {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.addAll(manual);
        tickets.addAll(random);
        this.tickets = tickets;
        this.manualAmount = manual.size();
        this.randomAmount = random.size();
    }

    public List<LottoTicket> getTickets() {
        return this.tickets;
    }

    public int getManualAmount() {
        return this.manualAmount;
    }

    public int getRandomAmount() {
        return this.randomAmount;
    }

    public int getInputMoney() {
        final int size = getManualAmount() + getRandomAmount();
        return LottoTicket.DEFAULT_PRICE * size;
    }

    public List<PrizeGroup> getPrizeGroups(WinningLotto winningLotto) {
        return getTickets()
                .stream()
                .map(lottoTicket -> PrizeGroup.findRankByCountOfMatchAndBonus(lottoTicket, winningLotto))
                .collect(Collectors.toList());
    }

    public LottoResultDto match(WinningLotto winningLotto) {
        List<PrizeGroup> prizeGroups = getPrizeGroups(winningLotto);
        return new LottoResultDto(prizeGroups);
    }
}
