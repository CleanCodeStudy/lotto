package domain;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNo {
    private static int MIN_BOUNDARY = 1;
    private static int MAX_BOUNDARY = 45;

    private static Map<Integer, LottoNo> ALL_LOTTO_NUMBER;

    private Integer number;

    static {
        ALL_LOTTO_NUMBER = getInstance();
    }

    public LottoNo(int number) {
        validateCorrect(number);
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    private static Map<Integer, LottoNo> getInstance() {
        return IntStream.rangeClosed(MIN_BOUNDARY, MAX_BOUNDARY)
                .boxed()
                .map(LottoNo::new)
                .collect(Collectors.toMap(LottoNo::getNumber, Function.identity()));
    }

    private static void validateCorrect(int number) {
        if (number < MIN_BOUNDARY || number > MAX_BOUNDARY) {
            throw new IllegalArgumentException();
        }
    }

    public static LottoNo selectNumber(int number) {
        validateCorrect(number);
        return ALL_LOTTO_NUMBER.get(number);
    }
}

