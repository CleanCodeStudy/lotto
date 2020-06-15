package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.number.GameNumber;
import com.javabom.lotto.domain.number.OrderGameNumber;

import java.util.List;

public class LottoTicket {
    public static final int COUNT = 6;
    public static final int PRICE = 1000;

    private final List<OrderGameNumber> lottoTicket;

    public LottoTicket(List<OrderGameNumber> lottoTicket) {
        checkDuplicate(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    private void checkDuplicate(List<OrderGameNumber> maybeLottoTicket) {
        int size = getDeduplicationSize(maybeLottoTicket);
        if (size != COUNT) {
            throw new IllegalArgumentException(String.format("현재 개수: %d, 로또 번호의 갯수는 6개여야 합니다.", size));
        }
    }

    private int getDeduplicationSize(List<OrderGameNumber> maybeLottoTicket) {
        return (int) maybeLottoTicket.stream()
                .distinct()
                .count();
    }

    public boolean contains(OrderGameNumber gameNumber) {
        return lottoTicket.contains(gameNumber);
    }

    public boolean containsBonus(final OrderGameNumber bonusNumber) {
        return lottoTicket.stream()
                .anyMatch(number -> number.equalsOfNumber(bonusNumber));
    }

    public GameNumber get(final int i) {
        return lottoTicket.get(i).numberValue();
    }
}
