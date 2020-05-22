package com.javabom.lotto.view;

import com.javabom.lotto.domain.*;

import java.util.HashMap;
import java.util.List;

public class OutputView {

    public static void printLottoNumbers(List<LottoNumber> lottoNumbers) {
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");
        for (LottoNumber number : lottoNumbers) {
            System.out.println(number.toString());
        }
    }

    public static void printWinningStatistics(HashMap<LottoRank, Integer> eachRackCount, int profitRatio) {
        System.out.println("\n당첨 통계");
        System.out.println("----------");
        printWinningNumberCount(eachRackCount);
        printProfitRatio(profitRatio);
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
