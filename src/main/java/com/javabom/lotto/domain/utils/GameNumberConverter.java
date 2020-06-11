package com.javabom.lotto.domain.utils;

import com.javabom.lotto.domain.number.GameNumber;

import java.util.List;
import java.util.stream.Collectors;

public class GameNumberConverter {

    public static List<GameNumber> convert(List<String> strGameNumbers) {
        checkCount(strGameNumbers.size());
        List<GameNumber> maybeGameNumbers = strGameNumbers.stream()
                .distinct()
                .map(GameNumber::valueOf)
                .collect(Collectors.toList());
        checkDuplicate(maybeGameNumbers.size());
        return maybeGameNumbers;
    }

    private static void checkCount(int numberCount) {
        if (numberCount != GameNumber.COUNT) {
            throw new IllegalArgumentException(String.format("%d개의 당첨 번호를 입력하셨습니다. 당첨 번호는 총 6개여야 합니다.", numberCount));
        }
    }

    private static void checkDuplicate(int gameNumbersSize) {
        if (gameNumbersSize != GameNumber.COUNT) {
            throw new IllegalArgumentException("당첨 번호는 모두 달라야 합니다.");
        }
    }

}
