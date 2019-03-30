package view;

import model.LottoMachine;
import model.LottoRank;
import model.LottoTicket;
import model.LottoYield;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {


    public static void viewLottoTicketsNum(LottoMachine lottoMachine) {
        StringBuilder sb = new StringBuilder();
        List<LottoTicket> lottos = lottoMachine.getLottoTickets();

        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.",
                lottoMachine.getManualLottoTicektCount(), lottoMachine.getAutoLottoTicketCount()));

        lottos.stream()
                .forEach(lotto -> {
                    sb.append(lotto.getNumbers()
                            .stream()
                            .map(num -> String.valueOf(num))
                            .collect(Collectors.joining(",", "[", "]\n")));
                });

        System.out.println(lottos.size() + "개를 구매했습니다.");
        System.out.println(sb);


    }

    public static void viewLottoAnalyze(LottoYield lottoYield) {

        StringBuilder sb = new StringBuilder();

        Map<LottoRank, List<LottoTicket>> analysis = lottoYield.getRankLottoGroup();
        System.out.println();
        System.out.println("당첨통계\n---------");
        for (LottoRank lottoRank : analysis.keySet()) {
            sb.append(String.format("%d개 일치 (%d원)- %d개\n",
                    lottoRank.getCorrectRank(), lottoRank.getPrice(), analysis.get(lottoRank).size()));
        }

        System.out.println(sb);
        System.out.println(String.format("총 수익률은 %.1f% 입니다.", lottoYield.getYield()));

    }

}
