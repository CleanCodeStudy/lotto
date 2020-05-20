package com.javabom.lotto.view;

import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoTickets;

import java.util.stream.Collectors;

public class OutputView {

    public static final String NOTICE_BUY_COMPLETE = "개를 구매했습니다.";

    public static void printLottoTickets(LottoTickets lottoTickets) {
        printLineOf(lottoTickets.get().size() + NOTICE_BUY_COMPLETE);
        for (LottoTicket lottoTicket : lottoTickets.get()) {
            printLineOf(stringOf(lottoTicket));
        }
    }

    private static String stringOf(LottoTicket lottoTicket) {
        String lottoNumbers = lottoTicket.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        return new StringBuilder()
                .append("[")
                .append(lottoNumbers)
                .append("]")
                .toString();
    }


    private static void printChangeLine() {
        System.out.println();
    }

    private static void printLineOf(String string) {
        System.out.println(string);
    }

    private static void printStringOf(String string) {
        System.out.print(string);
    }
}
