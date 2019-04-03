package domain.result;

import domain.LottoTicket;
import domain.PurchasedLottos;

import java.util.*;
import java.util.stream.Collectors;

public class WinningResult {
    private List<LottoResult> lottoResults;
    private double yield;

    public WinningResult(PurchasedLottos lottos, List<String> winningNumbers) {
        this.lottoResults = confirmLottos(lottos.getLottoTickets(), convertToBoxedInt(winningNumbers));
        this.yield = calculateYield(lottos.getPrice());
    }

    public double getYield() {
        return yield;
    }

    public long getResult(Rank rank) {
        return rank.count(lottoResults);
    }

    private double calculateYield(long buyPrice) {
        long price = Arrays.stream(Rank.values())
                .mapToLong(this::calculatePrice)
                .sum() / buyPrice;

        return price * 100;
    }

    private List<LottoResult> confirmLottos(List<LottoTicket> lottoTickets, List<Integer> winningNumbers) {
        return lottoTickets.stream()
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
}
