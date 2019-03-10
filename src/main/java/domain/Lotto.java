package domain;

import util.NumberGenerator;

import java.util.Collection;
import java.util.List;

public class Lotto {
    List<Integer> numbers;

    public Lotto(NumberGenerator numberGenerator){
        this.numbers = numberGenerator.createNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
