package com.javabom.lotto.view;

import com.javabom.lotto.domain.enums.PrizeType;
import com.javabom.lotto.domain.info.Lotto;
import com.javabom.lotto.domain.info.LottoBundle;
import com.javabom.lotto.domain.result.LottoResultBundle;
import com.javabom.lotto.domain.vo.Money;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OutputView {

    private static final int BONUS_COUNT = 5;
    private static final int BONUS_NUMBER = 50;

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printMyLottoBundle(LottoBundle lottoShop) {
        List<Lotto> lottoBundle = lottoShop.getMyLottoBundle();
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

    public static void printResults(LottoResultBundle lottoResultBundle, Money money) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for (int mathcedCount = 3; mathcedCount <= 6; mathcedCount++) {
            printResult(lottoResultBundle, mathcedCount);
        }
        printRateOfProfit(lottoResultBundle, money);
    }

    private static void printResult(LottoResultBundle lottoResultBundle, int mathcedCount){
        if (mathcedCount == BONUS_COUNT) {
            System.out.println(mathcedCount + "개 일치(" + PrizeType.valueOfPrize(BONUS_NUMBER).getPrize() + ")- " + lottoResultBundle.getCountOfPrize(BONUS_NUMBER));
        }
        System.out.println(mathcedCount + "개 일치(" + PrizeType.valueOfPrize(mathcedCount).getPrize() + ")- " + lottoResultBundle.getCountOfPrize(mathcedCount));
    }

    private static void printRateOfProfit(LottoResultBundle lottoResultBundle, Money money) {
        System.out.println("총 수익률은 " + lottoResultBundle.getRateOfProfit(money)+"%입니다.");
    }
}
