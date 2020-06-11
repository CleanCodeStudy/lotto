package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.number.GameNumber;

import java.util.List;

public class LottoTicket {
    public static final int PRICE = 1000;

    private final List<GameNumber> lottoTicket;
    private int matchedCount;

    private LottoTicket(List<GameNumber> lottoTicket, int matchedCount) {
        checkDuplicate(lottoTicket);
        this.lottoTicket = lottoTicket;
        this.matchedCount = matchedCount;
    }

    public LottoTicket(List<GameNumber> lottoTicket) {
        this(lottoTicket, 0);
    }

    private void checkDuplicate(List<GameNumber> maybeLottoTicket) {
        int size = getDeduplicationSize(maybeLottoTicket);
        if (size != GameNumber.COUNT) {
            throw new IllegalArgumentException(String.format("현재 개수: %d, 로또 번호의 갯수는 6개여야 합니다.", size));
        }
    }

    private int getDeduplicationSize(List<GameNumber> maybeLottoTicket) {
        return (int) maybeLottoTicket.stream()
                .distinct()
                .count();
    }

    public boolean contains(GameNumber gameNumber) {
        return lottoTicket.contains(gameNumber);
    }

    public GameNumber get(int idx) {
        return lottoTicket.get(idx);
    }

    public void match(GameNumber prizeNumber, int idx) {
        if (prizeNumber.equals(lottoTicket.get(idx))) {
            matchedCount++;
        }
    }

    public int getMatchedCount() {
        return matchedCount;
    }
}
