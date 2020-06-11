package com.javabom.lotto.view;

import com.javabom.lotto.domain.LottoResult;
import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.WinningSheet;
import com.javabom.lotto.domain.vo.LottoMoney;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final int NOT_LOSE_RATE = 1;

    private OutputView() {
    }

    public static void printNumberOfTicket(LottoMoney lottoMoney) {
        System.out.println(String.format("수동으로 %d개, 자동으로 %d개를 구매했습니다.", lottoMoney.getNumberOfManualTicket()
                , lottoMoney.getNumberOfAutoTicket()));
    }

    public static void printLottoTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.forEach(lottoTicket -> System.out.println(lottoTicket.getLottoNumbers()));
    }

    public static void printWinningStatistics(LottoResult lottoResult, LottoMoney lottoMoney) {
        System.out.println("당첨 통계");

        System.out.println("----------");

        for (Map.Entry<WinningSheet, Integer> statistics : lottoResult.getWinningStatistics().entrySet()) {
            WinningSheet winningSheet = statistics.getKey();

            String format = winningSheet.equals(WinningSheet.SECOND) ? "%d개 일치 보너스 볼 일치(%d원)- %d개" :
                    "%d개 일치 (%d원)- %d개";

            System.out.println(String.format(format, winningSheet.getMatchCount()
                    , winningSheet.getPrize(), statistics.getValue()));
        }

        printRateOfReturn(lottoMoney.calculateRateOfReturn(lottoResult.sumAllPrize()));
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
