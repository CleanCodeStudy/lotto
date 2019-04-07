package domain.vo;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int LOTTO_END_NUMBER;
    public static final int LOTTO_START_NUMBER;
    private static final Map<Integer, LottoNumber> LOTTO_NUMBERS ;

    static {
        LOTTO_START_NUMBER = 1;
        LOTTO_END_NUMBER = 45;
        LOTTO_NUMBERS = createLottoNumbers();
    }

    private Integer number;

    public LottoNumber(Integer number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public static LottoNumber pickNumber(int number) {
        validateNumber(number);
        return LOTTO_NUMBERS.get(number);
    }

    public static LottoNumber pickNumber(String number) {
        return pickNumber(Integer.parseInt(number));
    }

    private static void validateNumber(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private static Map<Integer, LottoNumber> createLottoNumbers() {
        return getNumbers().stream()
                .map(LottoNumber::new)
                .collect(Collectors.toMap(LottoNumber::getNumber, Function.identity()));
    }

    public static List<Integer> getNumbers(){
        return IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
