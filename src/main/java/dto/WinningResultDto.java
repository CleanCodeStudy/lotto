package dto;

import domain.Rank;
import domain.vo.Money;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResultDto {
    private Money prize;
    private Map<Rank,Integer> results = new HashMap<>();

    public WinningResultDto(List<Rank> lottoResults) {
        initMap();
        for (Rank lottoResult : lottoResults) {
            putRank(lottoResult);
        }
        this.prize = getTotalReward(lottoResults);
    }

    private void initMap() {
        for (Rank rank : Rank.values()) {
            results.put(rank,0);
        }
    }

    private void putRank(Rank rank){
        results.computeIfPresent(rank,(Rank key, Integer value) -> ++value);
    }

    public double getYield() {
        Money money = Money.getInvestment(getLottoCount());
        return prize.calculate(money);
    }

    public int getResults(Rank rank) {
        return results.get(rank);
    }

    public int getLottoCount(){
        return results.values().stream()
                .mapToInt(count->count)
                .sum();
    }

    private Money getTotalReward(List<Rank> results) {
        Long money = results.stream()
                .mapToLong(Rank::getPrice)
                .sum();

        return new Money(money);
    }
}
