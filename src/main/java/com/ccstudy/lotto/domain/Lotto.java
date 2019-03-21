package com.ccstudy.lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getAnswer(List<Integer> correctAnswer) {
        return (int)numbers.stream()
                .filter(correctAnswer::contains)
                .count();
    }
}
