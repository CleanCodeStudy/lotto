package view;

import domain.bundle.LottoBundle;
import dto.LottoResultDto;
import util.PrizeGroup;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static int MIN_RANK = 3;

    public void showBuyedList(LottoBundle lottoBundle) {
        lottoBundle.showList();
    }

    public String getStatistics(LottoResultDto lottoResultDto) {
        String prefix = "당첨 통계\n----------\n";
        String body = getBody(lottoResultDto.getPrizeStat());
        String suffix = String.format("\n총 수익률은 %.2f%% 입니다.", lottoResultDto.getRate());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(prefix)
                .append(body)
                .append(suffix);

        return stringBuilder.toString();
    }

    private String getBody(List<PrizeGroup> prizeGroupList) {
        return Arrays.stream(PrizeGroup.values())
                .filter(prizeGroup -> prizeGroup.getCountOfMatch() >= MIN_RANK)
                .map(prizeGroup -> getLine(prizeGroup, prizeGroupList))
                .collect(Collectors.joining("\n"));
    }

    private String getLine(PrizeGroup prizeGroup, List<PrizeGroup> prizeGroupList) {
        long amount = prizeGroupList.stream()
                .filter(oneOfList -> prizeGroup.getMoney() == oneOfList.getMoney())
                .count();

        StringBuilder sb = new StringBuilder();
        sb.append(prizeGroup.getComment())
                .append(" - ")
                .append(amount);

        return sb.toString();
    }

}
