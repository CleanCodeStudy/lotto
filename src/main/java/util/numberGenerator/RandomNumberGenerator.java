package util.numberGenerator;

import domain.LottoNo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator implements NumberGenerator {

    private final int LOTTO_LIMIT = 6;
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;

    private List<Integer> create() {
        return IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<LottoNo> createLottoNumbers() {
        List<Integer> numbers = create();
        Collections.shuffle(numbers);

        return numbers.stream()
                .limit(LOTTO_LIMIT)
                .sorted()
                .map(integer -> new LottoNo(integer))
                .collect(Collectors.toList());
    }

}