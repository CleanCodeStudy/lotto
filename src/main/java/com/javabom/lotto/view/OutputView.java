package com.javabom.lotto.view;

import com.javabom.lotto.domain.LottoResult;
import com.javabom.lotto.domain.LottoTicket;
import com.javabom.lotto.domain.WinningSheet;
import com.javabom.lotto.domain.vo.LottoMoney;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final int NOT_LOSE_RATE = 1;

    private OutputView() {
    }

    public static void printNumberOfTicket(LottoMoney lottoMoney) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoMoney.getNumberOfTicket()));
    }

    public static void printLottoTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.stream()
                .forEach(OutputView::printOneLottoTicket);
    }

    private static void printOneLottoTicket(LottoTicket lottoTicket) {
        String lottoNumbers = lottoTicket.getLottoNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(lottoNumbers);
    }

    public static void printWinningStatistics(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        Map<WinningSheet, Long> winningStatistics = lottoResult.getWinningStatistics();

        for (Map.Entry<WinningSheet, Long> statistics : winningStatistics.entrySet()) {
            WinningSheet winningSheet = statistics.getKey();

            System.out.println(String.format("%d개 일치 (%d원)- %d개", winningSheet.getMatchCount(),
                    winningSheet.getPrice(),
                    statistics.getValue()));
        }

        printRateOfReturn(lottoResult.calculateRateOfReturn());
    }

    private static void printRateOfReturn(double rateOfReturn) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("총 수익률은 %.2f 입니다.");

        if (rateOfReturn < NOT_LOSE_RATE) {
            stringBuilder.append("기준이 1이기 때문에 결과적으로 손해라는 의미임");
        }

        System.out.println(String.format(stringBuilder.toString(), rateOfReturn));
    }
}
