package com.ccstudy.lotto.view;

import com.ccstudy.lotto.domain.Lotto;
import com.ccstudy.lotto.domain.LottoResult;
import com.ccstudy.lotto.util.LottoRank;

import java.util.List;

public class Output {
    public static void printPurchaseLottos(List<Lotto> lottos){
        lottos.stream()
                .map(lotto -> lotto.getNumbers().toString())
                .forEach(System.out::println);
    }

    public static void printWinningStatistics(LottoResult lottoResult){
        System.out.println("당첨 통계\n" +
                "-------");

        for (LottoRank lottoRank : LottoRank.values()) {
            String statistics = lottoRank.isCorrectBonus() ?
                    String.format("%d개 일치,보너스 볼 일치 (%d원)- %d개", lottoRank.getCorrectCount(),
                            lottoRank.getReceivedAmount(), lottoResult.getWinningLottoCount(lottoRank))
                    : String.format("%d개 일치 (%d원)- %d개", lottoRank.getCorrectCount(),
                    lottoRank.getReceivedAmount(), lottoResult.getWinningLottoCount(lottoRank));

            System.out.println(statistics);
        }

    }

    public static void printYield(LottoResult lottoResult){
        System.out.println(String.format("총 수익률은 %.1f 입니다.",lottoResult.getYield()));
    }
}
