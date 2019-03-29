package dto;

import domain.WinningLotto;
import domain.bundle.LottoBundle;
import util.PrizeGroup;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResultDto {

    private static final int DEFAULT_PRICE = 1000;
    private static final int PER = 100;

    private List<PrizeGroup> prizeStat;
    private long sum;
    private double rate;

    public List<PrizeGroup> getPrizeStat() {
        return this.prizeStat;
    }

    public long getSum() {
        return this.sum;
    }

    public double getRate() {
        return this.rate;
    }

    public LottoResultDto(LottoBundle lottoBundle, WinningLotto winningLotto) {
        this.prizeStat = getStat(lottoBundle, winningLotto);
        this.sum = getAllPrize();
        this.rate = getRate(lottoBundle);
    }

    private List<PrizeGroup> getStat(LottoBundle lottoBundle, WinningLotto winningLotto) {
        return lottoBundle.getLottoTickets()
                .stream()
                .map(lottoTicket -> PrizeGroup.findRankByCountOfMatchAndBonus(lottoTicket, winningLotto))
                .collect(Collectors.toList());
    }

    private long getAllPrize() {
        return prizeStat.stream()
                .mapToLong(PrizeGroup::getMoney)
                .sum();
    }

    private double getRate(LottoBundle lottoBundle) {
        int ticketAmount = lottoBundle.getLottoTickets().size();
        int inputPrice = ticketAmount * DEFAULT_PRICE;

        return (double) (this.sum - inputPrice) / inputPrice * PER;
    }


}
