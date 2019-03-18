package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private List<Lotto> lottos;
    private List<Integer> winNumbers;


    public LottoGame(List<Lotto> lottos, List<Integer> winNumbers) {
        this.lottos = lottos;
        this.winNumbers = winNumbers;
    }

    public Map<LottoRank, Integer> makeResult() {
        Map<LottoRank, Integer> resultMap = new HashMap<>();

        for (LottoRank lottoRank : LottoRank.values()) {
            Integer rankCount = Math.toIntExact(
                    lottos.stream()
                            .filter(lotto -> lotto.getAnswer(winNumbers) == lottoRank.getCorrectRank())
                            .count());
            resultMap.put(lottoRank, rankCount);
        }

        return resultMap;
    }

}
