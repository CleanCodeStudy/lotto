package view;

import domain.PurchasedLottos;
import domain.result.PurchasedResult;
import domain.result.Rank;

import java.util.Arrays;

public class ResultView {
    public static void printMyLottos(PurchasedLottos purchasedLottos) {
        purchasedLottos.getLottos().forEach(lotto -> System.out.println(lotto.toString()));
    }

    public static void printResults(PurchasedResult purchasedResult) {
        Arrays.stream(Rank.values())
                .forEach(rank -> printResult(purchasedResult, rank));

        System.out.println(String.format("총 수익률은 %2.1f입니다.", purchasedResult.getYield()));
    }

    private static void printResult(PurchasedResult result, Rank rank) {
        System.out.println(String.format("%d개 일치 (%d원) - %d개", rank.getAmount(), rank.getPrice(), result.getResult(rank)));
    }
}
