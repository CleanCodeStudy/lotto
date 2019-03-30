package model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {

    public static final int LOTTO_PRICE = 1000;
    public static final int BONUS_INDEX = 6;

    private List<Integer> winNumbers;
    private LottoMachine lottoMachine;
    private Integer bonusNumber;

    public LottoGame(List<Integer> winNumbers, LottoMachine lottoMachine) {
        this.bonusNumber = winNumbers.remove(BONUS_INDEX);
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
        List<LottoTicket> bonusRankLottoGroup = findBonusRankLottoGroup(resultMap.get(LottoRank.SECOND));

        return resultMap;
    }

    public List<LottoTicket> findBonusRankLottoGroup(List<LottoTicket> secondGroup){

        List<LottoTicket> bonusRankGroup = secondGroup.stream()
                .filter(lottoTicket -> lottoTicket.
                        getNumbers()
                        .stream()
                        .anyMatch(lottoNumber -> lottoNumber == bonusNumber)
                )
                .collect(Collectors.toList());

        return bonusRankGroup;
    }
}
