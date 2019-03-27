package util.numberGenerator;

import domain.LottoNo;

import java.util.List;
import java.util.stream.Collectors;

public class FixedNumberGenerator implements NumberGenerator {

    private List<Integer> numbers;

    public FixedNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<LottoNo> createLottoNumbers() {
        return numbers.stream()
                .map(integer -> new LottoNo(integer))
                .collect(Collectors.toList());
    }
}
