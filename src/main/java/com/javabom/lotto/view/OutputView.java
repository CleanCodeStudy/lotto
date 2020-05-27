package com.javabom.lotto.view;

import com.javabom.lotto.domain.dto.WinningStatisticsDto;
import com.javabom.lotto.domain.result.LottoRank;
import com.javabom.lotto.domain.ticket.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLotteryTickets(LottoTickets lottoNumbers) {
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");
        for (LottoTicket number : lottoNumbers.getNumbers()) {
            printLottoNumber(number);
        }
    }

    public static void printLottoNumber(LottoTicket lottoTicket) {
        List<String> numbers = lottoTicket.getNumbers().stream()
                .map(LottoNumber::getNumber)
                .map(Object::toString)
                .collect(Collectors.toList());
        System.out.println("[" + String.join(", ", numbers) + "]");
    }

    public static void printWinningStatistics(WinningStatisticsDto winningStatisticsDto) {
        System.out.println("\n당첨 통계");
        System.out.println("----------");
        printWinningNumberCount(winningStatisticsDto);
        printProfitRatio(winningStatisticsDto.getProfitRatio());
    }

    private static void printProfitRatio(int profitRatio) {
        System.out.printf("총 수익률은 %d%%입니다.\n", profitRatio);
    }

    private static void printWinningNumberCount(WinningStatisticsDto winningStatisticsDto) {
        Map<LottoRank, Integer> eachLottoRankCount = winningStatisticsDto.getEachLottoRankCount();
        for (LottoRank lottoRank : eachLottoRankCount.keySet()) {
            System.out.println(lottoRank.getRankInfo() + "- " + eachLottoRankCount.get(lottoRank) + "개");
        }
    }
}
