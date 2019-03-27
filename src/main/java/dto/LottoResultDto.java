package dto;

import domain.WinningLotto;
import domain.bundle.LottoBundle;
import util.PrizeGroup;

import java.util.HashMap;
import java.util.Map;

public class LottoResultDto {

    private static final int DEFAULT_PRICE = 1000;
    private static final int PER = 100;
    private static final int DEFAULT_AMOUNT = 1;

    private Map<PrizeGroup, Integer> prizeMap;
    private double rate;

    public LottoResultDto(LottoBundle lottoBundle, WinningLotto winningLotto) {
        this.prizeMap = makeMap(lottoBundle, winningLotto);
        this.rate = getRate(lottoBundle);
    }

    public Map<PrizeGroup, Integer> getPrizeMap() {
        return this.prizeMap;
    }

    private Map<PrizeGroup, Integer> makeMap(LottoBundle lottoBundle, WinningLotto winningLotto) {
        Map<PrizeGroup, Integer> map = new HashMap<>();

        lottoBundle.getLottoTickets()
                .stream()
                .map(lottoTicket -> PrizeGroup.findRankByCountOfMatchAndBonus(lottoTicket, winningLotto))
                .forEach(prizeGroup -> map.put(prizeGroup, getAmountOfPrizeGroup(map, prizeGroup)));

        return map;
    }

    private int getAmountOfPrizeGroup(Map<PrizeGroup, Integer> map, PrizeGroup prizeGroup) {
        if (map.containsKey(prizeGroup)) {
            return map.get(prizeGroup) + DEFAULT_AMOUNT;
        }
        return DEFAULT_AMOUNT;
    }


    public int getSumOfReward() {
        return prizeMap.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey()
                        .getReward(entry.getValue()))
                .sum();
    }

    private double getRate(LottoBundle randomLottoBundle) {
        int inputPrice = randomLottoBundle.getLottoTickets().size() * DEFAULT_PRICE;
        return (double) (getSumOfReward() - inputPrice) / inputPrice * PER;
    }

    public double getRate() {
        return this.rate;
    }

}
