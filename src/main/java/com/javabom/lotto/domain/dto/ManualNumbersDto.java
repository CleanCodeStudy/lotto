package com.javabom.lotto.domain.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ManualNumbersDto {
    private final List<Integer> manualNumbers;

    public ManualNumbersDto(String[] manualNumbers) {
        try {
            this.manualNumbers = Stream.of(manualNumbers)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요. - " + Arrays.toString(manualNumbers));
        }
    }

    public List<Integer> getManualNumbers() {
        return manualNumbers;
    }
}
