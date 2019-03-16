package util;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FlexibleNumberGeneratorTest {

    @Test
    public void 시작_숫자_기반으로_생성하기(){
        //given
        FlexibleNumberGenerator flexibleNumberGenerator = new FlexibleNumberGenerator(1);

        //when
        //then
        assertThat(flexibleNumberGenerator.createNumbers()).contains(1,2,3,4,5,6);
        assertThat(flexibleNumberGenerator.createNumbers()).contains(2,3,4,5,6,7);
    }

}