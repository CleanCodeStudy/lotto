package domain.bundle;

import domain.LottoTicket;
import domain.WinningLotto;
import domain.prize.PrizeGroup;
import dto.LottoResultDto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoBundle {

    private List<LottoTicket> tickets;

    public LottoBundle(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public List<LottoTicket> getTickets() {
        return this.tickets;
    }

    public int getManualAmount() {
        int total = this.tickets.size();
        return total - (int) this.tickets.stream()
                .filter(LottoTicket::isRandom)
                .count();
    }

    public int getRandomAmount() {
        return (int) this.tickets.stream()
                .filter(LottoTicket::isRandom)
                .count();
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
