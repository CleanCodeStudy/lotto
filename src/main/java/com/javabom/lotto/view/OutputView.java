package com.javabom.lotto.view;

import com.javabom.lotto.domain.LottoGameResult;
import com.javabom.lotto.domain.LottoTickets;

public class OutputView {

    private OutputView() {
    }

    public static void printLottoTicketNumbers(LottoTickets lottoTickets) {
        System.out.printf("%d개를 구매했습니다.%n", lottoTickets.getNumberOfTickets());

        lottoTickets.getLottoTickets().forEach(System.out::println);
    }

    public static void printWinningResult(LottoGameResult lottoGameResult, int totalPrice) {
        System.out.printf("3개 일치(5000)원 %d개%n", lottoGameResult.findByHitCount(3));
        System.out.printf("4개 일치(50000)원 %d개%n", lottoGameResult.findByHitCount(4));
        System.out.printf("5개 일치(150000)원 %d개%n", lottoGameResult.findByHitCount(5));
        System.out.printf("6개 일치(2000000000)원 %d개%n", lottoGameResult.findByHitCount(6));
        System.out.printf("총 수익률은 %f입니다.%n", lottoGameResult.calculateRateOfProfit(totalPrice));
    }

}
