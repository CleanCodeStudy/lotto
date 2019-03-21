package com.ccstudy.lotto.view;

import com.ccstudy.lotto.domain.Lotto;
import com.ccstudy.lotto.domain.LottoResult;
import com.ccstudy.lotto.util.ReceivedType;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Output {
    public static void printPurchaseLottos(List<Lotto> lottos){
        lottos.stream()
                .map(lotto -> lotto.getNumbers().toString())
                .forEach(System.out::println);
    }

    public static void printWinningStatistics(LottoResult lottoResult){
        System.out.println("당첨 통계\n" +
                "-------");

        for(ReceivedType receivedType : ReceivedType.values()){
            System.out.println(String.format("%d개 일치 (%d원)- %d개",receivedType.getCorrectCount(),
                    receivedType.getReceivedAmount(),lottoResult.getWinningLottoCount(receivedType.getCorrectCount())));
        }

    }

    public static void printYield(LottoResult lottoResult){
        System.out.println(String.format("총 수익률은 %.1f 입니다.",lottoResult.getYield()));
    }
}
