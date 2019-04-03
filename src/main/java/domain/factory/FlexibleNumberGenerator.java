package domain.factory;

import domain.factory.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class FlexibleNumberGenerator implements NumberGenerator {
    private int startNumber;

    public FlexibleNumberGenerator(int startNumber) {
        this.startNumber = startNumber;
    }

    @Override
    public List<Integer> createNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = startNumber; i < startNumber + 6; i++) {
            numbers.add(i);
        }

        startNumber++;
        return numbers;
    }
}
