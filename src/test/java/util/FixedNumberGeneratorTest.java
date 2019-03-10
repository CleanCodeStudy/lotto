package util;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FixedNumberGeneratorTest {

    @Test
    public void 고정숫자_생성하기(){
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator();

        List<Integer> numbers = fixedNumberGenerator.createNumbers();

        //사이즈검사
        assertThat(numbers.size()).isEqualTo(6);
        //고정숫자 생성되었는지 확인
        assertThat(numbers).contains(1,2,3,4,5,6);
    }

}