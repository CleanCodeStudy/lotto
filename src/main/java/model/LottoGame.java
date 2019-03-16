package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoGame {

    private List<Lotto> lottos;
    private HashMap<LottoRank, Integer> resultMap = new HashMap<>();

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public HashMap<LottoRank, Integer> getResult(List<Integer> correctAnswer){
        for(LottoRank lottoRank : LottoRank.values()){
            Integer rankCount = Math.toIntExact(lottos.stream()
                    .filter(lotto -> lotto.getAnswer(correctAnswer) == lottoRank.getCorrectRank())
                    .count());
            resultMap.put(lottoRank, rankCount);
        }
        return resultMap;
    }

}
