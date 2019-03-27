package view;

import domain.bundle.LottoBundle;
import dto.LottoResultDto;
import util.PrizeGroup;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static int MIN_RANK = 3;
    private static int NOTTHING = 0;

    public void showBuyedList(LottoBundle lottoBundle) {
        lottoBundle.showList();
    }


    public String getStatistics(LottoResultDto lottoResultDto) {
        Map<PrizeGroup, Integer> prizeMap = lottoResultDto.getPrizeMap();

        String prefix = "당첨 통계\n----------\n";
        String result = getResult(prizeMap);
        String suffix = String.format("\n총 수익률은 %.2f%% 입니다.", lottoResultDto.getRate());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(prefix)
                .append(result)
                .append(suffix);

        return stringBuilder.toString();
    }

    private String getResult(Map<PrizeGroup, Integer> prizeMap) {
        return Arrays.stream(PrizeGroup.values())
                .filter(prizeGroup -> prizeGroup.getCountOfMatch() >= MIN_RANK)
                .map(prizeGroup -> makeLine(prizeMap, prizeGroup))
                .collect(Collectors.joining("\n"));
    }

    private String makeLine(Map<PrizeGroup, Integer> prizeMap, PrizeGroup prizeGroup) {
        return prizeGroup.getComment() + " - " + prizeMap.getOrDefault(prizeGroup, NOTTHING);
    }

}
