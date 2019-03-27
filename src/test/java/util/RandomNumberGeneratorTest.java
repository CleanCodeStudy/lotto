package util;

import domain.LottoNo;
import org.junit.Test;
import util.numberGenerator.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @Test
    public void 난수번호_생성하기() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<LottoNo> numbers = randomNumberGenerator.createLottoNumbers();

        //사이즈검사
        assertThat(numbers.size()).isEqualTo(6);
        //오름차순검사
        assertThat(numbers.stream()
                .map(LottoNo::getNumber)
                .collect(Collectors.toList())).isSorted();
    }

}