package view;

import data.PurchaseInfo;
import model.LottoMachine;
import model.LottoRank;
import model.LottoResult;
import model.LottoTicket;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {


    public static void viewLottoTicketsNum(PurchaseInfo purchaseInfo, LottoMachine lottoMachine) {
        List<LottoTicket> lottos = lottoMachine.getLottoTickets();

        System.out.println();
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.",
                purchaseInfo.getManualTicketCount(), purchaseInfo.getAutoTicketCount()));

        lottos.stream()
                .forEach(lotto -> {
                    lotto.printList();
                });
    }

    public static void viewLottoAnalyze(LottoResult lottoResult, PurchaseInfo purchaseInfo) {

        StringBuilder sb = new StringBuilder();

        System.out.println();
        System.out.println("당첨통계\n---------");
        for(LottoRank lottoRank : LottoRank.values()){
            if(lottoRank.getCorrectRank() == 0 )
                continue;
            if(lottoRank.getCorrectRank() == -1){
                sb.append(String.format("5개 일치,보너스볼 (%d원)- %d개\n",
                        lottoRank.getPrice(), lottoResult.getResultCount(lottoRank)));
            }else{
                sb.append(String.format("%d개 일치 (%d원)- %d개\n",
                        lottoRank.getCorrectRank(), lottoRank.getPrice(), lottoResult.getResultCount(lottoRank)));
            }
        }

        System.out.println(sb);
        System.out.println(String.format("총 수익률은 %.1f", lottoResult.analyzeYield(purchaseInfo))+"% 입니다.");

    }
}
