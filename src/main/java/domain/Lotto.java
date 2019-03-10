package domain;

import util.NumberGenerator;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(NumberGenerator numberGenerator) {
        this.numbers = numberGenerator.createNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


    public int getCorrectAmount(List<Integer> winningNumbers) {

        int amount = 0;

        for (Integer winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                amount++;
            }
        }

        return amount;
    }

    public boolean hasNumber(int winningNumber){
        return numbers.contains(winningNumber);
    }
}
