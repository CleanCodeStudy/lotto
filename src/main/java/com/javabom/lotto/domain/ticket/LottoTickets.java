package com.javabom.lotto.domain.lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        tickets = lottoTickets;
    }

    // TODO 이 부분이랑 LotteryResult 부분 리팩토링 및 구조 다시 보기.
    public List<LottoRank> findRanks(WinningLottoNumbers winningLottoNumbers) {
        List<LottoNumber> numbers = winningLottoNumbers.getWinningTicket();
        LottoNumber bonusNumber = winningLottoNumbers.getBonusNumber();
        List<LottoRank> lottoRanks = new ArrayList<>();
        for (LottoTicket lottoTicket : tickets) {
            int sameCountByWinnerNumbers = lottoTicket.getSameCountByWinnerNumbers(numbers);
            boolean hasBonusNumber = lottoTicket.hasBonusNumber(bonusNumber);
            LottoRank lottoRank = LottoRank.findLottoRank(sameCountByWinnerNumbers, hasBonusNumber);
            lottoRanks.add(lottoRank);
        }
        return lottoRanks;
    }
    public List<LottoTicket> getNumbers() {
        return Collections.unmodifiableList(tickets);
    }

    public int size() {
        return tickets.size();
    }
}
