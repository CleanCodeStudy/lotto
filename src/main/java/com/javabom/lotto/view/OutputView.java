package com.javabom.lotto.view;

import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoTicketBundle;
import com.javabom.lotto.domain.result.LottoResultBundle;

import java.util.List;

public class OutputView {

    private static final int BONUS_COUNT = 5;

    public static void printLottoCount(int manualLottoCount, int autoLottoCount) {
        System.out.println("수동으로 " + manualLottoCount + "장 자동으로" + autoLottoCount + "개를 구매했습니다.");
    }

    public static void printLottoBundle(LottoTicketBundle lottoTickets) {
        List<LottoTicket> lottoTicketBundle = lottoTickets.get();
        for (LottoTicket lottoTicket : lottoTicketBundle) {
            System.out.print("[");
            for (int i = 0; i < 5; i++) {
                System.out.print(lottoTicket.get(i).value() + ", ");
            }
            System.out.println(lottoTicket.get(5).value() + "]");
        }
    }

    public static void printResults(LottoResultBundle lottoResultBundle, int amount) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for (int mathcedCount = 3; mathcedCount <= 6; mathcedCount++) {
            printResult(lottoResultBundle, mathcedCount);
        }
        printRateOfProfit(lottoResultBundle, amount);
    }

    private static void printResult(LottoResultBundle lottoResultBundle, int mathcedCount) {
        System.out.println(mathcedCount + "개 일치(" + LottoResult.valueOf(mathcedCount).getPrize() + ")- " + lottoResultBundle.getCountOfPrize(LottoResult.valueOf(mathcedCount)));
        if (mathcedCount == BONUS_COUNT) {
            System.out.println(mathcedCount + "개 일치(" + LottoResult.SECOND.getPrize() + ")- " + lottoResultBundle.getCountOfPrize(LottoResult.SECOND));
        }
    }

    private static void printRateOfProfit(LottoResultBundle lottoResultBundle, int amount) {
        System.out.println("총 수익률은 " + lottoResultBundle.getRateOfProfit(amount) + "%입니다.");
    }
}
