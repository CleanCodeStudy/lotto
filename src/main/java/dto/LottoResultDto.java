package dto;

import domain.LottoList;
import util.PrizeGroup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoResultDto {

    public static final int LOTTO_MIN_MATCH = 3;
    public static final int LOTTO_MAX_MATCH = 6;
    public static final int DEFAULT_PRICE = 1000;
    public static final int PER = 100;
    public static final int WIN_NUMBER = 3;

    private HashMap<Integer, Integer> prizeMap;
    private List<Integer> winningNumber;
    private double rate;

    public LottoResultDto(LottoList lottoList, List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
        this.prizeMap = makeMap(lottoList);
        this.rate = getRate(lottoList);
    }

    public HashMap<Integer, Integer> getPrizeMap() {
        return this.prizeMap;
    }

    private HashMap<Integer, Integer> makeMap(LottoList randomLottoList) {
        HashMap<Integer, Integer> map = new HashMap<>();
        IntStream.rangeClosed(LOTTO_MIN_MATCH, LOTTO_MAX_MATCH)
                .forEach(match -> map.put(match, randomLottoList.getCountByMatchAmount(match, winningNumber)));
        return map;
    }

    public int getPrizeSum() {
        return prizeMap.entrySet()
                .stream()
                .mapToInt(entry -> getPrize(entry))
                .sum();
    }

    private int getPrize(Map.Entry<Integer, Integer> entry) {
        return PrizeGroup.findPrize(entry.getKey())
                .getPrize(entry.getValue());
    }

    private double getRate(LottoList randomLottoList) {
        int inputPrice = randomLottoList.getLottos().size() * DEFAULT_PRICE;
        return (double) (getPrizeSum() - inputPrice) / inputPrice * PER;
    }

    public String getRate() {
        return this.rate + "%";
    }

    public String getResult() {
        String prefix = "당첨 통계\n----------\n";
        String result = Arrays.stream(PrizeGroup.values())
                .filter(prizeGroup -> prizeGroup.getMatch() >= WIN_NUMBER)
                .map(prizeGroup -> makeLine(prizeGroup))
                .collect(Collectors.joining("\n"));
        String suffix = "\n" + "총 수익률은 " + getRate() + " 입니다.";
        return prefix + result + suffix;
    }

    private String makeLine(PrizeGroup prizeGroup) {
        return prizeGroup.getComment() + " - " + prizeMap.get(prizeGroup.getMatch());
    }

}
