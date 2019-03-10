package util;

import java.util.Arrays;
import java.util.List;

public class FixedNumberGenerator implements NumberGenerator{
    @Override
    public List<Integer> createNumbers() {
        return Arrays.asList(1,2,3,4,5,6);
    }
}
