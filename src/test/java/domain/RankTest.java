package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    public void 맞은갯수가_당첨된건지_확인() {
        //given
        int count = 6;
        //when
        //then
        assertThat(Rank.일등.getAmount()).isEqualTo(count);
    }

    @Test
    public void 다섯개맞고_보너스볼_맞으면_이등() {
        //given
        int count = 5;
        //when
        //then
        assertThat(Rank.valueOf(true,count)).isEqualTo(Rank.이등);
    }


    @Test
    public void 다섯개맞으면_삼등() {
        //given
        int count = 5;
        //when
        //then
        assertThat(Rank.valueOf(false,count)).isEqualTo(Rank.삼등);
    }

    @Test
    public void 네개_미만맞으면_꽝() {
        //given
        int count = 3;
        //when
        //then
        assertThat(Rank.valueOf(false,3)).isEqualTo(Rank.꽝);
    }
}