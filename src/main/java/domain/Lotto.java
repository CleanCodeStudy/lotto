package domain;

import util.NumberGenerator;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(NumberGenerator numberGenerator) {
        this.numbers = numberGenerator.createNumbers();
    }

    public boolean hasNumber(int winningNumber) {
        return numbers.contains(winningNumber);
    }

}
