package view;

import domain.PurchasedLottos;
import domain.result.WinningResult;
import domain.result.Rank;

import java.util.Arrays;

public class ResultView {
    public static void printMyLottos(PurchasedLottos purchasedLottos) {
        purchasedLottos.getLottoTickets().forEach(lotto -> System.out.println(lotto.toString()));
    }

    public static void printResults(WinningResult winningResult) {
        Arrays.stream(Rank.values())
                .forEach(rank -> printResult(winningResult, rank));

        System.out.println(String.format("총 수익률은 %2.1f입니다.", winningResult.getYield()));
    }

    private static void printResult(WinningResult result, Rank rank) {
        System.out.println(String.format("%d개 일치 (%d원) - %d개", rank.getAmount(), rank.getPrice(), result.getResult(rank)));
    }
}
