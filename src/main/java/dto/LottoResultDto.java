package dto;

import domain.WinningLotto;
import domain.bundle.LottoBundle;
import util.PrizeGroup;

import java.util.List;

public class LottoResultDto {

    private static final int PER = 100;

    private List<PrizeGroup> prizeStat;
    private long totalPrize;
    private double rate;

    public List<PrizeGroup> getPrizeStat() {
        return this.prizeStat;
    }

    public long getTotalPrize() {
        return this.totalPrize;
    }

    public double getRate() {
        return this.rate;
    }

    public LottoResultDto(LottoBundle lottoBundle, WinningLotto winningLotto) {
        this.prizeStat = lottoBundle.getPrizeGroups(winningLotto);
        this.totalPrize = getAllPrize();
        this.rate = getRate(lottoBundle);
    }

    private long getAllPrize() {
        return prizeStat.stream()
                .mapToLong(PrizeGroup::getMoney)
                .sum();
    }

    private double getRate(LottoBundle lottoBundle) {
        int inputPrice = lottoBundle.getInputMoney();
        return (double) (this.totalPrize - inputPrice) / inputPrice * PER;
    }


}
