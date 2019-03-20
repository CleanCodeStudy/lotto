package com.ccstudy.lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Lotto {
    private List<Integer> numbers;
    private int answer;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getAnswer() {
        return answer;
    }

    public boolean isWinNumbers(List<Integer> correctAnswer){
        answer = (int)numbers.stream()
                .filter(correctAnswer::contains)
                .count();

        return answer > 2;
    }

    public String convert(){
        return "[" +
                numbers.stream()
                        .sorted()
                .map(Objects::toString)
                .collect(Collectors.joining(","))
                + "]";
    }
}
