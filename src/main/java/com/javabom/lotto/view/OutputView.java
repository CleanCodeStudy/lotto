package com.javabom.lotto.view;

import com.javabom.lotto.domain.lottery.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLottoNumbers(LottoNumbersList lottoNumbers) {
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");
        for (LottoNumbers number : lottoNumbers.getNumbers()) {
            printLottoNumber(number);
        }
    }

    public static void printLottoNumber(LottoNumbers lottoNumbers) {
        List<String> numbers = lottoNumbers.getNumbers().stream()
                .map(LottoNumber::get)
                .map(Object::toString)
                .collect(Collectors.toList());
        System.out.println("[" + String.join(", ", numbers) + "]");
    }

    public static void printWinningStatistics(WinningStatistics winningStatistics, int gameMoney) {
        System.out.println("\n당첨 통계");
        System.out.println("----------");
        printWinningNumberCount(winningStatistics.findEachRankCount());
        printProfitRatio(winningStatistics.calculateProfitRatio(gameMoney));
    }

    private static void printProfitRatio(int profitRatio) {
        System.out.printf("총 수익률은 %d%%입니다.\n", profitRatio);
    }

    private static void printWinningNumberCount(HashMap<LottoRank, Integer> eachRackCount) {
        for (LottoRank lottoRank : eachRackCount.keySet()) {
            printRankInfo(lottoRank);
            System.out.print("- " + eachRackCount.get(lottoRank) + "개\n");
        }
    }

    private static void printRankInfo(LottoRank lottoRank) {
        System.out.print(lottoRank.getSameCount() + "개 일치 " + "(" + lottoRank.getPrizeMoney() + "원)");
    }
}
