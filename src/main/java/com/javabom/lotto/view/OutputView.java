package com.javabom.lotto.view;

import com.javabom.lotto.dto.WinningStatisticsDto;
import com.javabom.lotto.domain.result.LottoRank;
import com.javabom.lotto.domain.ticket.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLotteryTickets(LottoTickets automaticTickets, LottoTickets manualTickets) {
        System.out.println();
        System.out.println(manualTickets.size() + "장, 자동으로 " + automaticTickets.size() + "개를 구매했습니다.");

        for (LottoTicket ticket : manualTickets.getTickets()) {
            printLottoNumber(ticket);
        }

        for (LottoTicket number : automaticTickets.getTickets()) {
            printLottoNumber(number);
        }
    }

    public static void printLottoNumber(LottoTicket lottoTicket) {
        List<String> numbers = lottoTicket.getLottoNumbers().stream()
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
        System.out.println("3개 일치(" + LottoRank.FIFTH_PLACE.getPrizeMoney() + "원) - " + eachLottoRankCount.get(LottoRank.FIFTH_PLACE) + "개");
        System.out.println("4개 일치(" + LottoRank.FOURTH_PLACE.getPrizeMoney() + "원) - " + eachLottoRankCount.get(LottoRank.FOURTH_PLACE) + "개");
        System.out.println("5개 일치(" + LottoRank.THIRD_PLACE.getPrizeMoney() + "원) - " + eachLottoRankCount.get(LottoRank.THIRD_PLACE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(" + LottoRank.SECOND_PLACE.getPrizeMoney() + "원) - " + eachLottoRankCount.get(LottoRank.SECOND_PLACE) + "개");
        System.out.println("6개 일치(" + LottoRank.FIRST_PLACE.getPrizeMoney() + "원) - " + eachLottoRankCount.get(LottoRank.FIRST_PLACE) + "개");
    }
}
