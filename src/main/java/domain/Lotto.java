package domain;

import util.NumberGenerator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(NumberGenerator numberGenerator) {
        this.numbers = numberGenerator.createNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String getListString() {
        return "[" + this.numbers.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", ")) + "]";
    }

    public int getMatchAmount(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(winningNumber -> hasNumber(winningNumber))
                .count();
    }

    public boolean isEqual(int match, List<Integer> winningNumbers) {
        return match == getMatchAmount(winningNumbers);
    }

    public boolean hasNumber(int winningNumber) {
        return numbers.contains(winningNumber);
    }
}
