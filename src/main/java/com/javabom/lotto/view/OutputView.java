package com.javabom.lotto.view;

import com.javabom.lotto.domain.results.LottoResult;
import com.javabom.lotto.domain.results.LottoResults;
import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoTickets;
import com.javabom.lotto.domain.ticket.Money;

import java.util.stream.Collectors;

public class OutputView {

    private static final String NOTICE_BUY_COMPLETE = "개를 구매했습니다.";
    private static final String NOTICE_WINNING_STATISTICS = "당첨 통계";
    private static final String NOTICE_MATCH_QUANTITY = "%d개 일치, ";
    private static final String NOTICE_PRIZE_MONEY = "(%d원)";
    private static final String NOTICE_MATCH_RESULT_QUANTITY = " - %d개";
    private static final String NOTICE_MATCH_BONUS = "보너스 볼 일치";
    private static final String NOTICE_EARNING_RATE = "총 수익률은 %.2f%% 입니다.";

    public static void printLottoTickets(LottoTickets lottoTickets) {
        printLineOf(lottoTickets.get().size() + NOTICE_BUY_COMPLETE);
        for (LottoTicket lottoTicket : lottoTickets.get()) {
            printLineOf(lottoTicket.toString());
        }
    }

    public static void printLottoResults(LottoResults lottoResults) {
        printLineOf(NOTICE_WINNING_STATISTICS);
        for (LottoResult resultKind : LottoResult.values()) {
            long resultSize = lottoResults.findResultsOf(resultKind).size();
            printLottoResult(resultKind, resultSize);
        }
    }

    private static void printLottoResult(LottoResult result, long resultSize) {
        if (result == LottoResult.LOSE) return;
        StringBuilder stringBuilder = new StringBuilder()
                .append(String.format(NOTICE_MATCH_QUANTITY, result.getMatchCount()));
        if (result == LottoResult.SECOND_PRIZE) {
            stringBuilder.append(NOTICE_MATCH_BONUS);
        }
        stringBuilder
                .append(String.format(NOTICE_PRIZE_MONEY, result.getPrice()))
                .append(String.format(NOTICE_MATCH_RESULT_QUANTITY, resultSize));
        printLineOf(stringBuilder.toString());
    }

    public static void printEarningRate(Money spendMoney, Money earnMoney) {
        double rate = spendMoney.calculateRatioOf(earnMoney);
        printLineOf(String.format(NOTICE_EARNING_RATE, rate));
    }

    private static void printLineOf(String string) {
        System.out.println(string);
    }
}
