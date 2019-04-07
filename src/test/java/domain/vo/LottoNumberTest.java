package domain.vo;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test
    public void 문자열로_로또숫자_가져오기() {
        //given
        String number = "1";
        //when
        LottoNumber lottoNumber = LottoNumber.pickNumber(number);
        //then
        assertThat(lottoNumber.getNumber()).isEqualTo(1);
    }

    @Test
    public void 숫자로_로또숫자_가져오기() {
        //given
        int number = 45;
        //when
        LottoNumber lottoNumber = LottoNumber.pickNumber(number);
        //then
        assertThat(lottoNumber.getNumber()).isEqualTo(45);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 범위초과한_숫자를_가져올시_예외발생() {
        //given
        int number = 46;
        //when
        //then
        LottoNumber lottoNumber = LottoNumber.pickNumber(number);
    }

    @Test
    public void 전체_숫자리스트_가져오기() {
        //given
        //when
        List<Integer> numbers = LottoNumber.getNumbers();
        //then
        for (int i = 1; i <=numbers.size() ; i++) {
            assertThat(numbers.get(i)).isEqualTo(i);
        }
    }

}