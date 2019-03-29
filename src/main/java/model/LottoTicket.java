package model;

import java.util.List;


public class LottoTicket {
    private List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
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
