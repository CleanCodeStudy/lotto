package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberGenerator implements NumberGenerator {

    private final int LOTTO_LIMIT = 6;

    @Override
    public List<Integer> createNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        return numbers.stream()
                .limit(LOTTO_LIMIT)
                .sorted()
                .collect(Collectors.toList());
    }

}