package domain;

import domain.vo.LottoNumber;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    public void 로또번호조회_1부터_45까지() {
        //given
        //when
        //then
        for (int i = LottoNumber.LOTTO_START_NUMBER; i <= LottoNumber.LOTTO_END_NUMBER ; i++) {
             LottoNumber number = LottoNumber.pickNumber(i);
             assertThat(number.getNumber()).isEqualTo(i);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호_없는번호_조회시_에러발생() {
        //given
        //when
        //then
        LottoNumber.pickNumber(46);
    }
}