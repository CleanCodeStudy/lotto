package util;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @Test
    public void 난수번호_생성하기() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        List<Integer> numbers = randomNumberGenerator.createNumbers();

        //사이즈검사
        assertThat(numbers.size()).isEqualTo(6);
        //오름차순검사
        assertThat(numbers).isSorted();
    }

}