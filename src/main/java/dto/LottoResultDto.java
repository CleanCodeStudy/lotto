package dto;

import domain.LottoTicket;
import domain.prize.PrizeGroup;
import domain.WinningLotto;
import domain.bundle.LottoBundle;

import java.util.List;

public class LottoResultDto {

    private static final int PER = 100;

    private List<PrizeGroup> prizeStat;

    public LottoResultDto(List<PrizeGroup> prizeGroupList) {
        this.prizeStat = prizeGroupList;
    }

    public LottoResultDto(LottoBundle lottoBundle, WinningLotto winningLotto) {
        this.prizeStat = lottoBundle.getPrizeGroups(winningLotto);
    }

    public List<PrizeGroup> getPrizeStat() {
        return this.prizeStat;
    }

    public double getRate() {
        int inputPrice = prizeStat.size() * LottoTicket.DEFAULT_PRICE;
        return (double) (getAllPrize() - inputPrice) / inputPrice * PER;
    }

    public long getAllPrize() {
        return prizeStat.stream()
                .mapToLong(PrizeGroup::getMoney)
                .sum();
    }

}
