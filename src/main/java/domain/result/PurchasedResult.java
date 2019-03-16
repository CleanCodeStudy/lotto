package domain.result;

import domain.Lotto;
import domain.PurchasedLottos;

import java.util.*;
import java.util.stream.Collectors;

public class PurchasedResult {
    private List<LottoResult> lottoResults;
    private double yield;

    public PurchasedResult(PurchasedLottos lottos, List<String> winningNumbers) {
        this.lottoResults = confirmLotto(lottos.getLottos(), convertToBoxedInt(winningNumbers));
        this.yield = calculateYield(lottos.getPrice());
    }

    public double getYield() {
        return yield;
    }

    private double calculateYield(long buyPrice) {
        long price = Arrays.stream(Rank.values())
                .mapToLong(this::calculatePrice)
                .sum() / buyPrice;

        return price * 100;
    }

    private List<LottoResult> confirmLotto(List<Lotto> lottos, List<Integer> winningNumbers) {
        return lottos.stream()
                .map(lotto -> new LottoResult(lotto, winningNumbers))
                .collect(Collectors.toList());
    }

    private long calculatePrice(Rank rank) {
        return rank.count(lottoResults) * rank.getPrice();
    }

    private List<Integer> convertToBoxedInt(List<String> numbers) {
        return numbers.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public long getResult(Rank rank) {
        return rank.count(lottoResults);
    }
}
