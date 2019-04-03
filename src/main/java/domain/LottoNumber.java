package domain;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_START_NUMBER = 1;
    private static final Map<Integer, LottoNumber> LOTTO_NUMBERS = createLottoNumbers();
    private Integer number;

    public LottoNumber(Integer number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public static LottoNumber getNumber(int number) {
        validateNumber(number);
        return LOTTO_NUMBERS.get(number);
    }

    private static void validateNumber(int number) {
        if (number < 0 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    private static Map<Integer, LottoNumber> createLottoNumbers() {
        return IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toMap(LottoNumber::getNumber, Function.identity()));
    }
}
