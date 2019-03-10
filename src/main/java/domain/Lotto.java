package domain;

import java.util.List;


public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getAnswer(List<Integer> correctAnswer) {

        return (int) numbers.stream()
                .filter(correctAnswer::contains)
                .count();
    }
}
