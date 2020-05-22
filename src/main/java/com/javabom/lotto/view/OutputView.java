package com.javabom.lotto.view;

import com.javabom.lotto.domain.Lotto;
import com.javabom.lotto.domain.MyLottoBundle;
import com.javabom.lotto.domain.PrizeCounts;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printMyLottoBundle(MyLottoBundle myLottoBundle) {
        List<Lotto> lottoBundle = myLottoBundle.getMyLottoBundle();
        for (Lotto lotto : lottoBundle) {
            List<String> strLotto = getStrLotto(lotto.getLotto());
            System.out.println("[" + strLotto.stream().
                    collect(Collectors.joining(",")) + "]");
        }
    }

    private static List<String> getStrLotto(List<Integer> lotto) {
        return lotto.stream()
                .map(Objects::toString)
                .collect(Collectors.toList());
    }

    public static void printResult(PrizeCounts prizeCounts, int rateOfProfit) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        List<Integer> prizeMoney = Arrays.asList(5000, 50000, 15000000, 2000000000);
        for (int idx = 3; idx <= 6; idx++) {
            System.out.println(idx + "개 일치  :{" + prizeMoney.get(idx - 3) + "원)- " + prizeCounts.getPrizeCount(idx));
            checkBonus(prizeCounts, idx * 10);
        }

        System.out.println("총 수익률은 " + rateOfProfit + "%입니다.");
    }

    private static void checkBonus(PrizeCounts prizeCounts, int idx) {
        if (prizeCounts.containKey(idx)) {
            System.out.println("5개 일치, 보너스 볼 일치(300000000원)- " + prizeCounts.getPrizeCount(idx));
        }
    }
}
