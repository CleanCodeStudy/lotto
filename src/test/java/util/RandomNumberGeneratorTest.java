package util;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @Test
    public void 난수번호_생성하기(){
        //given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        //when
        List<Integer> numbers =  randomNumberGenerator.createNumbers();

        //then
        assertThat(numbers.size()).isEqualTo(6);
        assertThat(numbers).isSorted();
    }

}