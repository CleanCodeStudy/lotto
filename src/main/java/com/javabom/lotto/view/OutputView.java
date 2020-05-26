package com.javabom.lotto.view;

import com.javabom.lotto.domain.result.LottoPrize;
import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.ticket.LottoTickets;
import com.javabom.lotto.vo.Money;

public class OutputView {

    private OutputView() {
    }

    public static void printLottoTicketNumbers(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.count() + "개를 구매했습니다.");
        lottoTickets.getLottoTickets().forEach(System.out::println);
    }

    public static void printResult(LottoResult lottoResult, Money spentMoney) {
        System.out.println("당첨통계");
        System.out.println("--------");
        System.out.printf("3개 일치(5000원) - %d개%n", lottoResult.getNumberOfHitTickets(LottoPrize.THREE_HIT));
        System.out.printf("4개 일치(50000) - %d개%n", lottoResult.getNumberOfHitTickets(LottoPrize.FOUR_HIT));
        System.out.printf("5개 일치(1500000) - %d개%n", lottoResult.getNumberOfHitTickets(LottoPrize.FIVE_HIT));
        System.out.printf("6개 일치(2000000000) - %d개%n", lottoResult.getNumberOfHitTickets(LottoPrize.SIX_HIT));
        System.out.println("총 수익률은 " + lottoResult.getRateOfProfit(spentMoney) + "입니다.");
    }
}
