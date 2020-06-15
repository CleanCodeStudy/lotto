package com.javabom.lotto.domain.number;

import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.utils.GameNumberConverter;

import java.util.List;

public class PrizeNumbers {

    private final List<OrderGameNumber> prizeNumbers;

    public PrizeNumbers(List<String> strPrizeNumbers) {
        this.prizeNumbers = collect(strPrizeNumbers);
    }

    private List<OrderGameNumber> collect(final List<String> strPrizeNumbers) {
        checkCount(strPrizeNumbers.size());
        List<OrderGameNumber> prizeNumbers = GameNumberConverter.convert(strPrizeNumbers);
        checkDuplicate(prizeNumbers.size());
        return prizeNumbers;
    }

    private static void checkCount(int numberCount) {
        if (numberCount != LottoTicket.COUNT) {
            throw new IllegalArgumentException(String.format("%d개의 당첨 번호를 입력하셨습니다. 당첨 번호는 총 6개여야 합니다.", numberCount));
        }
    }

    private static void checkDuplicate(int gameNumbersSize) {
        if (gameNumbersSize != LottoTicket.COUNT) {
            throw new IllegalArgumentException("당첨 번호는 모두 달라야 합니다.");
        }
    }

    public boolean contains(OrderGameNumber orderGameNumber) {
        return prizeNumbers.stream()
                .anyMatch(number -> number.equalsOfNumber(orderGameNumber));
    }

    public int getMatchedCount(final LottoTicket lottoTicket) {
        return (int) prizeNumbers.stream()
                .filter(lottoTicket::contains)
                .count();
    }
}
