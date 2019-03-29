package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {

    public static final int LOTTO_PRICE = 1000;

    private List<Integer> winNumbers;
    private LottoMachine lottoMachine;

    public LottoGame(List<Integer> winNumbers, LottoMachine lottoMachine) {
        this.winNumbers = winNumbers;
        this.lottoMachine = lottoMachine;
    }

    public Map<LottoRank, List<LottoTicket>> getRankLottoGroup() {
        List<LottoTicket> lottoTickets = lottoMachine.getLottoTickets();
        Map<LottoRank, List<LottoTicket>> resultMap = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            List<LottoTicket> nowRankLottoTick = lottoTickets.stream()
                    .filter(lottoTicket -> lottoTicket.getAnswer(winNumbers) == lottoRank.getCorrectRank())
                    .collect(Collectors.toList());
            resultMap.put(lottoRank, nowRankLottoTick);
        }
        resultMap.remove(LottoRank.OUT);
        return resultMap;
    }
}
