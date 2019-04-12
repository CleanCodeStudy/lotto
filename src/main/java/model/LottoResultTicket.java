package model;

import data.WinnigNumber;

public class LottoResultTicket {
    private LottoTicket lottoTicket;
    private LottoRank lottoRank;

    public LottoResultTicket(LottoTicket lottoTicket, WinnigNumber winnigNumber) {
        this.lottoTicket = lottoTicket;
        this.lottoRank = findLottoRank(winnigNumber);
    }

    private LottoRank findLottoRank(WinnigNumber winnigNumber) {
        int collectCount = lottoTicket.getCollectCount(winnigNumber.getWinnings());

        if (collectCount == LottoRank.SECOND.getCorrectRank() && lottoTicket.contains(winnigNumber.getBonus())) {
            return LottoRank.SECOND_BONUS;
        }

        return LottoRank.findByCorrectRank(collectCount);
    }


    public LottoRank getLottoRank() {
        return lottoRank;
    }
}
