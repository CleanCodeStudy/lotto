package util;

import java.util.Arrays;
import java.util.List;

public class FixedNumberGenerator implements NumberGenerator {

    private int addingValue;

    public FixedNumberGenerator(int value) {
        this.addingValue = value;
    }

    @Override
    public List<Integer> createNumbers() {
        return Arrays.asList(1 + addingValue, 2 + addingValue, 3 + addingValue, 4 + addingValue, 5 + addingValue, 6 + addingValue);
    }
}
