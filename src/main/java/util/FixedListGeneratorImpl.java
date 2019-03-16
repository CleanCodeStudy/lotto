package util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FixedListGeneratorImpl implements NumberListGenerator { //123456
    private List<Integer> lottoRange = IntStream.range(1, 45)
            .mapToObj(Integer::new)
            .collect(Collectors.toList());

    @Override
    public List<Integer> getSixList() {
        return lottoRange.stream()
                .limit(6)
                .collect(Collectors.toList());
    }
}
