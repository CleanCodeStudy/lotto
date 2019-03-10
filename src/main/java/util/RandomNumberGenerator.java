package util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator implements NumberGenerator {

    private final int LOTTO_LIMIT = 6;
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;

    @Override
    public List<Integer> createNumbers() {
        List<Integer> numbers = create();

        Collections.shuffle(numbers);

        return numbers.stream()
                .limit(LOTTO_LIMIT)
                .sorted()
                .collect(Collectors.toList());
    }

    private List<Integer> create(){
        return IntStream.rangeClosed(LOTTO_START_NUMBER,LOTTO_END_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

}