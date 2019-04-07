package domain;

import domain.vo.LottoNumber;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int LOTTO_PRICE = 1000;

    private List<LottoNumber> numbers;

    private LottoTicket(String numbers) {
        this.numbers = pickManualNumbers(numbers);
    }

    private LottoTicket() {
        this.numbers = pickRandomNumbers();
    }

    private List<LottoNumber> pickRandomNumbers() {
        return getRandomNumbers().stream()
                .map(LottoNumber::pickNumber)
                .collect(Collectors.toList());
    }

    private List<LottoNumber> pickManualNumbers(String numbers) {
        String[] splitNumber = numbers.split(",");

        return Arrays.stream(splitNumber)
                .map(LottoNumber::pickNumber)
                .collect(Collectors.toList());
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> numbers = LottoNumber.getNumbers();
        Collections.shuffle(numbers);

        return numbers.stream()
                .limit(6)
                .sorted()
                .collect(Collectors.toList());
    }


    public boolean hasNumber(LottoNumber winningNumber) {
        return numbers.stream()
                .anyMatch(number -> number.equals(winningNumber));
    }

    public static LottoTicket createManualLotto(String number) {
        return new LottoTicket(number);
    }

    public static LottoTicket createAutoLotto() {
        return new LottoTicket();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
