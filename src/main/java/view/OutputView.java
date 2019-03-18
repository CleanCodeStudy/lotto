package view;

import model.Lotto;
import model.LottoRank;
import model.LottoResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public static void viewRandomNum(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();

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

    public static void viewLottoAnalyze(LottoResult lottoResult) {

        StringBuilder sb = new StringBuilder();

        Map<LottoRank, Integer> analysis = lottoResult.getLottoResultAnalysis();

        System.out.println();
        System.out.println("당첨통계\n---------");
        for (LottoRank lottoRank : analysis.keySet()) {
            sb.append(String.format("%d개 일치 (%d원)- %d개\n",
                    lottoRank.getCorrectRank(), lottoRank.getPrice(), analysis.get(lottoRank)));
        }

        System.out.println(sb);
        System.out.println(String.format("총 수익률은 %.1f 입니다.", lottoResult.getYield()));

    }

}
